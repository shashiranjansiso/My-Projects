package com.sbu.async;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbu.utils.OperationType;
import com.sbu.utils.Reply;
import com.sbu.utils.Request;
import com.sbu.utils.RequestHistory;
import com.sbu.utils.UDPClient;
import com.sbu.utils.UDPServer;


public class Client {	

	private static final Logger log = Logger.getLogger(Client.class.getName());
	private String TAG="";
	private String TAG_ERROR ="client_error : ";
	
	private  UDPServer clientUpdateReplyServer;
	String headServerIp;
	int headPort;
	String tailServerIp;
	int tailPort;
	int clientReplyPort;
	String clientIp;
	int retransmitTime;
	int retryCount;
	CopyOnWriteArrayList<RequestHistory> sentReqList= new CopyOnWriteArrayList<RequestHistory>();
	java.util.Date date= new java.util.Date();
	
	public Client(String bankname, int clientno)
	{
		this.TAG= bankname +"::client"+clientno+ ":: ";
		this.TAG_ERROR=TAG + "client_error : ";
	}
	
	public void init(String headServerIp, int headPort, String tailServerIp, int tailPort, int clientReplyPort, String clientIp, int retransmitTime, int retryCount)
	{
		this.headServerIp=headServerIp;
		this.headPort=headPort;
		this.tailServerIp=tailServerIp;
		this.tailPort=tailPort;
		this.clientReplyPort=clientReplyPort;
		this.clientIp=clientIp;
		
		this.retransmitTime=retransmitTime;
		this.retryCount=retryCount;
		log.debug(TAG + "Client Initiated with clientIp: "+clientIp+" clientPort: "+ clientReplyPort+ " headServerIp: "+headServerIp+
				" headPort: "+headPort+ " tailServerIp: "+tailServerIp+" tailPort: "+tailPort);
		
		initializeClientUDPSockets();
		initializeUDPUpdateReplyServer();
		checkRequest();
		
	}
	
	private void checkRequest()
	{
		Executors.newSingleThreadExecutor().execute(new Runnable(){
		    public void run(){
		        while(true)
		        {
		        	for (RequestHistory reqh : sentReqList) {
		        		  // System.out.println("reqid: "+reqh.getReqID());

		        		   if(date.getTime()-reqh.getTime() > retransmitTime && reqh.getRetryCount()<retryCount && !reqh.isReplyReceived()) 
		        		   {
		        			   System.out.println("Retry the update for "+reqh.toString());
		        			   log.debug(TAG+ "checkRequest "+ "Retry the update for "+reqh.toString());
		        			   updateBalance(reqh.getAccountNum(),reqh.getAmount(),reqh.getReqID(),reqh.getOperationType());
		        			   reqh.setRetryCount(reqh.getRetryCount()+1);
		        		   }
		        		}
		        	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		
	}
	
	public  void printReply(String msg){
		ObjectMapper mapper = new ObjectMapper();
		Reply reply;
		try {
			reply = mapper.readValue(msg, Reply.class);
			//System.out.println(TAG + "reply from bank : " + reply.toString());
			log.debug(TAG + "Reply from bank : " + reply.toString());
			//RequestHistory reqh=new RequestHistory(reply.getReqID());
			for (RequestHistory reqh : sentReqList) {
				if(reqh.getReqID().equals(reply.getReqID()))
				{
					reqh.setReplyReceived(true);
					//System.out.println("RequestHistory: Reply received for "+reqh.toString());
					//log.debug(TAG + "RequestHistory: Reply received for "+reqh.toString());
				}

			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private  void initializeClientUDPSockets()
	{
		
	}
	
	private  void initializeUDPUpdateReplyServer()
	{
		try {
			clientUpdateReplyServer = new UDPServer("My UDP server", "Example", InetAddress.getByName(clientIp), clientReplyPort,
			            0, 2, 2, this);
			clientUpdateReplyServer.Start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			log.debug(TAG_ERROR+"UDP server socket for receiving update reply failed..."+e.getMessage());
			//System.err.println(TAG_ERROR + " udp server socket for receiving update reply failed...");
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			//System.err.println(TAG_ERROR + " udp server socket for receiving update reply failed...");
			log.debug(TAG_ERROR+"UDP server socket for receiving update reply failed..."+e.getMessage());
		}
		//System.out.println(TAG + " udp server socket for receiving update reply opened successfully...");
		log.debug(TAG + "UDP server socket for receiving update reply opened successfully...");
	}
	
	public void updateBalance(int accNo, float amt, String reqId, OperationType operationType)
	{
		UDPClient headUDPClient;
		try {
			headUDPClient = new UDPClient("My UDP client", "Example", 0, 2,
			        2, InetAddress.getByName(headServerIp), headPort, this);
			headUDPClient.Start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.err.println(TAG_ERROR + " udp client socket for head failed...");
			log.debug(TAG_ERROR+ "UDP client socket for head failed..."+e.getMessage());
			return;
		}
		//System.out.println(TAG + " udp client socket for head opened successfully...");
		log.debug(TAG + "UDP client socket for head opened successfully...");
		 Request req = new Request();
		 //req.setReplyPort(this.clientReplyPort);
		 req.setOperationType(operationType);
		 req.setReqID(reqId);
		 req.setAccountNum(accNo);
		 req.setAmount(amt);
	     ObjectMapper mapper = new ObjectMapper();
	      try {
			String sentence = mapper.writeValueAsString(req);
			
			headUDPClient.sendMessageToServer(sentence);
			RequestHistory reqh=new RequestHistory(accNo,amt,reqId,operationType,date.getTime());
			if(!sentReqList.contains(reqh))
				sentReqList.add(reqh);
			
			//System.out.println(TAG + " sending update request : " + sentence);
			log.debug(TAG + " sending update request : " + sentence);
		} 
	      catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			//System.err.println(TAG_ERROR + " sending update requst to bank failed..."+e.getMessage());
	    	  log.debug(TAG_ERROR + " sending update requst to bank failed..."+e.getMessage());
		}
	      
	}
	public void queryBalance(int accNo,String reqId)
	{
		
		UDPClient tailUDPClient;
		try {
			tailUDPClient = new UDPClient("My UDP client", "Example", 0, 2,
			        2, InetAddress.getByName(tailServerIp), tailPort, this);
			tailUDPClient.Start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.err.println(TAG_ERROR + " udp client socket tail failed...");
			log.debug(TAG_ERROR + "UDP client socket tail failed..."+e.getMessage());
			return;
		}
		//System.out.println(TAG + " udp client socket for tail opened successfully...");
		log.debug(TAG + "UDP client socket for tail opened successfully...");
		
		Request req = new Request();
		//req.setReplyPort(this.clientReplyPort);
		 req.setOperationType(OperationType.QUERY);
		 req.setReqID(reqId);
		 req.setAccountNum(accNo);
		 //req.setAmount(100);
	     ObjectMapper mapper = new ObjectMapper();
	      try {
			String sentence = mapper.writeValueAsString(req);
			tailUDPClient.sendMessageToServer(sentence);
			//System.out.println(TAG + " Queried the bank " + sentence);
			log.debug(TAG + "Queried the bank " + sentence);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			//System.err.println(TAG_ERROR + " sending query request to bank failed...");
			log.debug(TAG_ERROR + " sending query request to bank failed..."+e.getMessage());
		}
	}

}
