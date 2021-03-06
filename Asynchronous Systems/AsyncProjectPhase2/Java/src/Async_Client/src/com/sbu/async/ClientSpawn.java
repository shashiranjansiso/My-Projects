package com.sbu.async;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;

import com.sbu.utils.OperationType;

public class ClientSpawn {

	private static final Logger log = Logger.getLogger(ClientSpawn.class.getName());
	private static final String TAG= "ClientSpawn";
	
	static int seq=0;
	public static void main(String[] args) {

		Properties prop = new Properties();
		InputStream input = null;
		
		//String filename = "config.properties";
		String filename = args[0];
		
		input = ClientSpawn.class.getClassLoader().getResourceAsStream(filename);
		if(input==null){
			System.out.println("Sorry, unable to load config file: " + filename);
			log.debug(TAG+"Sorry, unable to load config file: " + filename);
			return;
		}

		try
		{
			prop.load(input);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int bankNo=Integer.parseInt(prop.getProperty("bankNo"));
		for(int t=1; t <= bankNo; t++)
		{
			System.out.println("******************************************" + prop.getProperty("bank"+t)+"***************************************************************");

			String bankname= prop.getProperty("bank"+t);
			log.debug(TAG+"Client initiation for bank: " + bankname);
			
			String headServerIp= prop.getProperty("bank"+t+"headIp"); 
			int headPort=Integer.parseInt(prop.getProperty("bank"+t+"headPort"));
			String tailServerIp=prop.getProperty("bank"+t+"tailIp");
			int tailPort=Integer.parseInt(prop.getProperty("bank"+t+"tailPort"));
			
			int retransmitTime=Integer.parseInt(prop.getProperty("bank"+t+"retransmitTime"));
			int retryCount=Integer.parseInt(prop.getProperty("bank"+t+"retryCount"));

			String clientDetail= prop.getProperty("bank"+t+"clientDetail"); 
			String[] clientList = clientDetail.split(",");

			int banknumclient=Integer.parseInt(prop.getProperty("bank"+t+"numclient"));
			if(banknumclient!=clientList.length)
				System.out.println("banknumclient!=clientList.length");

			for(int i=0; i<clientList.length; i++)
			{	
				String ipport[]=clientList[i].split(":");
				String clientIp=ipport[0];
				int clientReplyPort=Integer.parseInt(ipport[1]);
				Client client = new Client(bankname,i+1);
				client.init(headServerIp, headPort, tailServerIp, tailPort, clientReplyPort, clientIp, retransmitTime, retryCount);

				String bankreqType=prop.getProperty("bank"+t+"reqType");

				if(bankreqType.equals("auto"))
				{
					Random generator = new Random();

					int numReq= Integer.parseInt(prop.getProperty("bank"+t+"numReq"));
					double numGetBalance=Double.parseDouble(prop.getProperty("bank"+t+"probGetBalance"))*numReq;
					double numDeposit=Double.parseDouble(prop.getProperty("bank"+t+"probDeposit"))*numReq;
					double numWithdraw=Double.parseDouble(prop.getProperty("bank"+t+"probWithdraw"))*numReq;
					
					for(int l=numReq; l>0; )
					{
						int select=generator.nextInt(100000)%3;
						int accNo=generator.nextInt(100000);
						int amt=generator.nextInt(1000);
						if(numDeposit>0 && select==0)
						{
							String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.updateBalance(accNo,amt,reqId, OperationType.DEPOSIT);
							numDeposit--; l--;
						}
						if(numWithdraw>0 && select==1)
						{
							String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.updateBalance(accNo,amt,reqId, OperationType.WITHDRAW);
							numWithdraw--; l--;
						}
						if(numGetBalance>0 && select==2)
						{
							String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.queryBalance(accNo, reqId);
							numGetBalance--; l--;
						}
					}
				}
				else if(bankreqType.equals("itemized"))
				{
					String bankitemisedReq=prop.getProperty("bank"+t+"client"+(i+1)+"itemisedReq");
					String reqlist[]=bankitemisedReq.split(";");
					for(int m=0;m<reqlist.length;m++)
					{
						String reqtype[]=reqlist[m].split(":");
						String operation=reqtype[0];
						if(operation.equalsIgnoreCase("getBalance"))
						{
							String reqargs[]=reqtype[1].split(",");
							//String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.queryBalance(Integer.parseInt(reqargs[0]), reqargs[1]);
						}
						if(operation.equalsIgnoreCase("deposit"))
						{
							String reqargs[]=reqtype[1].split(",");
							//String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.updateBalance(Integer.parseInt(reqargs[0]),Integer.parseInt(reqargs[1]),reqargs[2], OperationType.DEPOSIT);
						}
						if(operation.equalsIgnoreCase("withdraw"))
						{
							String reqargs[]=reqtype[1].split(",");
							//String reqId= prop.getProperty("bank"+t)+"."+"client"+(i+1)+"."+ seq++;
							client.updateBalance(Integer.parseInt(reqargs[0]),Integer.parseInt(reqargs[1]),reqargs[2], OperationType.WITHDRAW);
						}

					}

				}
				else
				{
					System.out.println("Invalid bankreqType");
					log.debug(TAG+"Invalid bankreqType");
				}
			}



		}

	}

}
