package com.sbu.async.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbu.async.Account;
import com.sbu.async.Bank;
import com.sbu.async.OperationType;
import com.sbu.async.Outcome;
import com.sbu.async.Reply;
import com.sbu.async.Request;
import com.sbu.async.Role;
import com.sbu.async.ServerInfo;
import com.sbu.async.Transaction;
import com.sbu.async.tcpsocket.TCPChatClient;
import com.sbu.async.tcpsocket.TCPChatServer;
import com.sbu.async.udpsocket.UDPClient;
import com.sbu.async.udpsocket.UDPServer;

public class Server {
	
	private static final Logger log = Logger.getLogger(Server.class.getName());
	private String TAG="";
	private String TAG_ERROR ="server_error : ";
	
	public Server(String bankname, int serverno, int chainlength)
	{
		String role=""; 
		if(serverno==1)
			role="head";
		if(serverno==chainlength)
			role="tail";
		
		this.TAG= bankname + "::" + role + "::server"+serverno+ ":: ";
		this.TAG_ERROR=TAG + "server_error : ";
	}

	
	private class ClientInfo{
		public int port;
		public int replyPort = 9999;
		public InetAddress inetAddress;
	}
	public static int replycount = 0;
	public static int updatereqcount = 0;
	private String myIP;
	private int myPort;
	private int myudpport;
	
	private static ClientInfo clientInfo;
	private UDPServer fUDPHeadServer;
	private UDPServer fUDPTailServer;
	private TCPChatClient tcpClientForSuccessor;
	private TCPChatServer tcpServerForPredecessor;
	private List<Bank> bankList = new ArrayList<Bank>();
	private volatile List<Account> accountList = new ArrayList<Account>();
	private List<Transaction> pendingList = new ArrayList<Transaction>();
	private  List<Transaction> completedTransactionList = new ArrayList<Transaction>();
	
	//forwarded transaction list to next server in chain
	private List<Transaction> sentList = new ArrayList<Transaction>();
	//update
	private ServerInfo successor;
	private ServerInfo predecessor;
	private Role role;
	private Transaction currTransaction;
	
	
	public synchronized Role getRole()
	{
		return role;
	}
	
	public synchronized void setIPPort(String ipAddr, int syncport)
	{
		this.myIP = ipAddr;
		this.myPort = syncport;
	}
	public synchronized void setIPPort(String ipAddr, int syncport,int udpport)
	{
		this.myIP = ipAddr;
		this.myPort = syncport;
		this.myudpport=udpport;
	}
	
	public synchronized void sendAckToPredecessor()
	{
		
		if(role == Role.HEAD)
			return;
		//System.out.println(TAG + "Sending ack to predecessor");
		log.debug(TAG + "Sending ack to predecessor");
		tcpServerForPredecessor.sendAckToPredecessor("ACK");
	}
	
	public synchronized void setSuccessor(ServerInfo successor)
	{
		if(role == Role.TAIL)
			return;
		this.successor = successor;
		try {
			tcpClientForSuccessor = new TCPChatClient(InetAddress.getByName(successor.ipAddr), successor.port, "guest");
			tcpClientForSuccessor.setBankServer(this);
			tcpClientForSuccessor.Start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	public synchronized void setPredecessor(ServerInfo predecessor)
	{
		
		this.predecessor = predecessor;
		try {
			tcpServerForPredecessor = new TCPChatServer(InetAddress.getByName(myIP), myPort);
			tcpServerForPredecessor.setBankServer(this);
			tcpServerForPredecessor.Start();
		} catch (UnknownHostException e) {
			log.debug(TAG_ERROR + "setPredecessor failed-"+e.getMessage());
		}
		catch (Exception e) {
			log.debug(TAG_ERROR + "setPredecessor failed-"+e.getMessage());
		}
//		System.out.println(TAG + "TCPChatServer started " );
	}
	
	public synchronized Reply update(OperationType operation, String reqID, int accNo, List<?> list)
	{
		Reply reply;
		currTransaction = new Transaction();
		currTransaction.setReqID(reqID);
		currTransaction.setOperation(operation);
		currTransaction.setAccount(accNo);
		currTransaction.setAmount((Float) (list.get(0)));
		if(isInconsistentWithHistory(currTransaction))
		{
			//inconsistent with history 
			log.debug(TAG + "ReqId: "+reqID+"-Transaction is inconsistent with history ");
			reply=new Reply();
			reply.setReqID(reqID);
			reply.setOutcome(Outcome.INCONSISTENTWITHHISTORY);
			reply.setBalance(getAccount(accNo).getBalance());
			currTransaction.setOutcome(reply.getOutcome());
			currTransaction.setBalance(reply.getBalance());
			return reply;
		}else if(isDuplicateRequest(currTransaction))
		{
			log.debug(TAG +"ReqId: "+reqID+ "-Duplicate transaction already processed ");
			reply=new Reply();
			reply.setReqID(reqID);
			reply.setOutcome(getDuplicateRequest(currTransaction).getOutcome());
			reply.setBalance(getDuplicateRequest(currTransaction).getBalance());
			return reply;
		}
		pendingList.add(currTransaction);
		switch (operation) {
		case DEPOSIT:
			deposit(reqID, accNo, (Float) (list.get(0)));
			pendingList.remove(currTransaction);
			reply=new Reply();
			reply.setReqID(reqID);
			reply.setOutcome(Outcome.PROCESSED);
			reply.setBalance(getAccount(accNo).getBalance());
			currTransaction.setOutcome(reply.getOutcome());
			currTransaction.setBalance(reply.getBalance());
			return reply;
		case WITHDRAW:
			Account account = getAccount(accNo);
			if(account == null)
			{
				account = createNewAccount(accNo);
				//reply = new Reply(reqID, Outcome.INSUFFICIENTFUNDS, getAccount(accNo).getBalance());
				reply=new Reply();
				reply.setReqID(reqID);
				reply.setOutcome(Outcome.INSUFFICIENTFUNDS);
				reply.setBalance(getAccount(accNo).getBalance());
				currTransaction.setOutcome(reply.getOutcome());
				currTransaction.setBalance(reply.getBalance());
				return reply;
			}
			if(getAccount(accNo).getBalance()<(Float) (list.get(0)))
			{
				//reply = new Reply(reqID, Outcome.INSUFFICIENTFUNDS, getAccount(accNo).getBalance());
				reply=new Reply();
				reply.setReqID(reqID);
				reply.setOutcome(Outcome.INSUFFICIENTFUNDS);
				reply.setBalance(getAccount(accNo).getBalance());
				currTransaction.setOutcome(reply.getOutcome());
				currTransaction.setBalance(reply.getBalance());
				return reply;
			}
			else
			{
				withdraw(reqID, accNo, (Float) (list.get(0)));
				pendingList.remove(currTransaction);
				//reply = new Reply(reqID, Outcome.PROCESSED, getAccount(accNo).getBalance());
				reply=new Reply();
				reply.setReqID(reqID);
				reply.setOutcome(Outcome.PROCESSED);
				reply.setBalance(getAccount(accNo).getBalance());
				currTransaction.setOutcome(reply.getOutcome());
				currTransaction.setBalance(reply.getBalance());
				return reply;
			}
		default:
			break;
		}
		return null;
	}
	
	private synchronized boolean isDuplicateRequest(Transaction trans)
	{
		for (Transaction transaction : completedTransactionList) {
			if((trans.getAccount() == transaction.getAccount()) &&
					(trans.getOperation().equals(transaction.getOperation())) &&
					(trans.getReqID().equals(transaction.getReqID())) &&
					(trans.getAmount() == transaction.getAmount())
					)
			{
				return true;
			}
		}
		return false;
	}
	
	private synchronized Transaction getDuplicateRequest(Transaction trans)
	{
		for (Transaction transaction : completedTransactionList) {
			if((trans.getAccount() == transaction.getAccount()) &&
					(trans.getOperation().equals(transaction.getOperation())) &&
					(trans.getReqID().equals(transaction.getReqID())) &&
					(trans.getAmount() == transaction.getAmount())
					)
			{
				return transaction;
			}
		}
		return null;
	}
	
	private synchronized void deposit(String reqID,int accountNum, float amount)
	{
//		System.out.println(TAG + "deposit method called..");
		Account account = getAccount(accountNum);
		if(account == null)
		{
			account = createNewAccount(accountNum);
		}
		account.setBalance(account.getBalance() + amount);
		//System.out.println("Server: deposit complete new balance is : " + account.getBalance());
		log.debug(TAG +"ReqId: "+reqID+ "-Deposit operation complete new balance is : " + account.getBalance());
		
	}
	
	private synchronized boolean withdraw(String reqID,int accountNum, float amount)
	{
		Account account = getAccount(accountNum);
		account.setBalance(account.getBalance() - amount);
		//System.out.println("Server: withdraw complete new balance is : " + account.getBalance());
		log.debug(TAG +"ReqId: "+reqID+ "-Withdraw operation complete new balance is : " + account.getBalance());
		return true;
	}
	
	private synchronized void sendSyncToSuccessor(Request req) {
		if(role == Role.TAIL)
		{
			//System.out.println("I am tail sending reply to client and ack to predecessor");
			log.debug(TAG +"ReqId: "+req.getReqID() + "Reply to client and ack to predecessor-ReqId: "+req.getReqID());
			sendAckToPredecessor();
			Reply reply = new Reply();
			reply.setReqID(req.getReqID());
			reply.setOutcome(Outcome.PROCESSED);
			reply.setBalance(getAccount(req.getAccountNum()).getBalance());
			replyToClient(reply);
			return;
		}

		log.debug(TAG+"ReqId: "+req.getReqID() + "Sendin sync to successor");
		
		//send sync to sucessor
		ObjectMapper parser = new ObjectMapper();
		synchronized (parser) {
			try {
				tcpClientForSuccessor.SendDataToServer(parser.writeValueAsString(req));
			} catch (JsonProcessingException e) {
				System.out.println(TAG_ERROR + "request format is not correct");
				log.debug(TAG_ERROR + "request format is not correct-"+e.getMessage());
				return;
			}
		}

	}

	private synchronized void replyToClient(Reply reply) {
		log.debug(TAG +" ReqId: "+reply.getReqID()+"Reply to client : "+ clientInfo.inetAddress + " port:" + clientInfo.replyPort);
		UDPClient fUDPClient;
		try {
			fUDPClient = new UDPClient("My UDP client", "Example", 0, 2,
			        2, clientInfo.inetAddress, clientInfo.replyPort);
			fUDPClient.Start();
			 ObjectMapper mapper = new ObjectMapper();
		      try {
				String sentence = mapper.writeValueAsString(reply);
				//mapper.writeValueAsBytes(arg0)
				fUDPClient.sendMessageToServer(sentence);
			} catch (JsonProcessingException e) {
				log.debug(TAG_ERROR + "Sending query request to bank failed..." + e.getMessage());
			}
			
//			fUDPClient.Stop();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(TAG + " replyToClient success");
		log.debug(TAG + "ReplyToClient success");
	}

	private synchronized boolean isInconsistentWithHistory(Transaction trans)
	{
		for (Transaction transaction : completedTransactionList) {
			if((trans.getReqID().equals(transaction.getReqID())
					&& (!(trans.getOperation().equals(transaction.getOperation())) | 
						(trans.getAccount() != transaction.getAccount()) |
						trans.getAmount() != transaction.getAmount())))
				return true;
		}
		//similarly check for pending list also
		return false;
	}
	
	
	private synchronized Account createNewAccount(int accountNum)
	{
		Account account = new Account();
		account.setAccountNum(accountNum);
		account.setBalance(0);
		accountList.add(account);
		log.debug(TAG + "New Account created with account no : " + accountNum);
		return account;
	}
	private synchronized Account getAccount(int accountNum)
	{
		for (Account account : accountList) {
			if(account.getAccountNum() == accountNum)
				return account;
		}
		return null;
	}
	
	public void setRole(Role role)
	{
		this.role = role;
	}
	
	private synchronized Reply processRequest(Request req)
	{
		log.debug(TAG + "ProcessRequest method called.."+req.getReqID());
		Vector<Float> v = new Vector<Float>();
		float amount = req.getAmount();
        v.add(amount);
        return update(req.getOperationType(), req.getReqID(), req.getAccountNum(), v);
	}
	
	public synchronized void eventQuery(InetAddress clientInetAddress, int clientPort, String args)
	{
		log.debug(TAG + "Received client Query request.."+ clientInetAddress.getHostAddress() + " port " + clientPort);
		if(role != Role.TAIL)
			return;
		ObjectMapper mapper = new ObjectMapper();
		Request req = null;
		try {
			req = mapper.readValue(args, Request.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			//System.out.println(TAG_ERROR + "request format is not correct");
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
			return;
//			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			//System.out.println(TAG_ERROR + "request format is not correct");
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
//			e.printStackTrace();
			return;
		} catch (IOException e) {

			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
//			e.printStackTrace();
			return;
		}
		if(req.getOperationType() != OperationType.QUERY)
			return;
		Reply reply;
		Account account = getAccount(req.getAccountNum());
		if(account == null)
		{
			log.info(TAG + "tail account is null");
			account = createNewAccount(req.getAccountNum());
		}
		reply = new Reply();
		reply.setReqID(req.getReqID());
		reply.setOutcome(Outcome.PROCESSED);
		reply.setBalance(account.getBalance());

		UDPClient fUDPClient;
		try {
			fUDPClient = new UDPClient("My UDP client", "Example", 0, 2,
			        2, clientInetAddress, clientPort);
			fUDPClient.Start();
			fUDPClient.sendMessageToServer(mapper.writeValueAsString(reply));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(TAG + "Client qurey replied..");
		log.debug(TAG+  "Client qurey replied..");
	}
	
	public synchronized void eventUpdate(InetAddress clientInetAddress, int clientPort, String args)
	{
		log.debug(TAG + "Received client Update request.." + clientInetAddress.getHostAddress() + " port " + clientPort);
		ObjectMapper mapper = new ObjectMapper();
		clientInfo = new ClientInfo();
		clientInfo.inetAddress = clientInetAddress;
		clientInfo.port = clientPort;
		try {
			Request req = mapper.readValue(args, Request.class);
			Reply reply = processRequest(req);
			log.debug(TAG + "Received Request No -"+ req.getReqID());
			sendSyncToSuccessor(req);
		} catch (JsonParseException e) {
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
		} catch (JsonMappingException e) {
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
//			e.printStackTrace();
		} catch (IOException e) {
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
//			e.printStackTrace();
		}
		
	}
	
	public synchronized void eventSync(String args)
	{
		//System.out.println(TAG + "sync from predecessor " + args);
		log.debug(TAG + "Sync from predecessor " + args);
		ObjectMapper parser = new ObjectMapper();
		Request req ;
		Reply reply = null;
		try {
			req = parser.readValue(args, Request.class);
			reply = processRequest(req);
				
		} catch (JsonParseException e) {

			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
			return;
//			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
			return;
//			e.printStackTrace();
		} catch (IOException e) {
			log.debug(TAG_ERROR + "Request format is not correct-"+e.getMessage());
			return;
//			e.printStackTrace();
		}
		
		if(role == Role.TAIL)
		{
			log.debug(TAG +" ReqId: "+reply.getReqID()+" Sending reply to client and ack to predecessor");
			if(!completedTransactionList.contains(currTransaction))
				completedTransactionList.add(currTransaction);
			replyToClient(reply);
			sendAckToPredecessor();
		}
		else
		{
			//send sync request to sucessor
			sendSyncToSuccessor(req);
		}
	}
	
	public synchronized void eventAck()
	{
		log.debug(TAG + "Received ack from predecessor- ReqId: "+currTransaction.getReqID());
		if(!completedTransactionList.contains(currTransaction))
			completedTransactionList.add(currTransaction);
		if(role == Role.HEAD)
		{
			log.debug(TAG + "Ack received at HEAD");
			return;
		}
		sendAckToPredecessor();
	}
	
	private void openUDPServerForClientUpdateRequest()
	{
		System.out.println(TAG + "HEAD::udp for client started at ip " +  myIP + " port: " + (this.myudpport));
		log.debug(TAG + "HEAD::udp for client started at ip " +  myIP + " port: " + (this.myudpport));
		try {
			fUDPHeadServer = new UDPServer("My UDP server", "Example", InetAddress.getByName(myIP), this.myudpport,
			            0, 2, 2);
			fUDPHeadServer.setBankServer(this);
			fUDPHeadServer.Start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(TAG_ERROR + " udp server at ip " +  myIP + " port: " + this.myudpport + " failed-" + e.getMessage());
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			log.debug(TAG_ERROR + " udp server at ip " +  myIP + " port: " + this.myudpport + " failed-" + e.getMessage());
			e.printStackTrace();
		}
//		System.out.println(TAG + "openUDPServerForClient end" );
	}
	
	private void openUDPServerForClientQueryRequest()
	{
		try {
			fUDPTailServer = new UDPServer("My TAIL UDP server", "For Query Request", InetAddress.getByName(myIP), this.myudpport,
			            0, 2, 2);
			fUDPTailServer.setBankServer(this);
			fUDPTailServer.Start();
			//System.out.println(TAG + "TAIL: query :: udp server at ip " +  myIP + " port: " + (myPort + 200) + " started..");
			log.debug(TAG + "Udp server at ip " +  myIP + " port: " + this.myudpport + " started..");
		} catch (UnknownHostException e) {
			//System.err.println(TAG_ERROR + "TAIL: query :: udp server at ip " +  myIP + " port: " + (myPort + 200) + " failed");
			log.debug(TAG_ERROR + " udp server at ip " +  myIP + " port: " + this.myudpport + " failed-" + e.getMessage());
		}
		catch (SocketException e) {
			log.debug(TAG_ERROR + " udp server at ip " +  myIP + " port: " + this.myudpport + " failed-" + e.getMessage());
		}
	}
	
	public void init(Role role) throws IOException {
		//System.out.println(TAG + " role " + role);
		log.debug(TAG + " Server started as " + role);
		setRole(role);
		if(role == Role.HEAD)
		{
			openUDPServerForClientUpdateRequest();
		}
		else if(role == Role.TAIL)
		{
			//open UDP connection for query request
			openUDPServerForClientQueryRequest();
		}
	}
}
