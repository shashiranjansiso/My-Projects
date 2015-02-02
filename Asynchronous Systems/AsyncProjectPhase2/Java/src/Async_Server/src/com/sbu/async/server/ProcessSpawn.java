package com.sbu.async.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import com.sbu.async.Role;
import com.sbu.async.ServerInfo;


public class ProcessSpawn {
	
	private static final Logger log = Logger.getLogger(ProcessSpawn.class.getName());
	private static final String TAG= "ProcessSpawn";
	
	public static void main(String[] args) throws IOException {
		
		
			Properties prop = new Properties();
			InputStream input = null;
			
			String filename = args[0];
			input = ProcessSpawn.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
		            System.out.println("Sorry, unable to load config file: " + filename);
		            log.debug(TAG+"Sorry, unable to load config file: " + filename);
			    return;
			}
			prop.load(input);

		ArrayList<Server> bankServers=new ArrayList<Server>();
		
		int numBanks=Integer.parseInt(prop.getProperty("numBanks"));
		log.debug(TAG+"Num of Banks for initiation: "+ prop.getProperty("numBanks"));
		
		
		for(int t=1;t<=numBanks; t++)
		{
			//System.out.println(prop.getProperty("bank"+t));
			log.debug(TAG+"bankname: "+ prop.getProperty("bank"+t));
			String bankname=prop.getProperty("bank"+t);
			
			int chainLength=Integer.parseInt(prop.getProperty("bank"+t+"chainlength"));
			log.debug(TAG+"chainLength: "+ chainLength);
			
			for(int i=chainLength; i>=1; i--)
			{
				
				Server server = new Server(bankname,i,chainLength);
				int syncport=Integer.parseInt(prop.getProperty("bank"+t+"server"+i+"syncport"));
				String ip=prop.getProperty("bank"+t+"server"+i+"ip");
				if(prop.getProperty("bank"+t+"server"+i+"udpport")!=null)
				{
					int udpport=Integer.parseInt(prop.getProperty("bank"+t+"server"+i+"udpport"));
					server.setIPPort(ip,syncport,udpport);
				}
				server.setIPPort(ip, syncport);
				
				if(i==chainLength)
				{
					ServerInfo predecessor = new ServerInfo();
					predecessor.ipAddr = prop.getProperty("bank"+t+"server"+(i-1)+"ip");
					predecessor.port = Integer.parseInt(prop.getProperty("bank"+t+"server"+(i-1)+"syncport"));
					server.setPredecessor(predecessor);
					server.setRole(Role.TAIL);
					server.init(Role.TAIL);
				}
				else if(i==1)
				{
					ServerInfo successor = new ServerInfo();
					successor.ipAddr = prop.getProperty("bank"+t+"server"+(i+1)+"ip");
					successor.port = Integer.parseInt(prop.getProperty("bank"+t+"server"+(i+1)+"syncport"));
					server.setSuccessor(successor);
					server.setRole(Role.HEAD);
					server.init(Role.HEAD);
						
				}
				else
				{
					ServerInfo successor = new ServerInfo();
					successor.ipAddr = prop.getProperty("bank"+t+"server"+(i+1)+"ip");
					successor.port = Integer.parseInt(prop.getProperty("bank"+t+"server"+(i+1)+"syncport"));
					ServerInfo predecessor = new ServerInfo();
					predecessor.ipAddr = prop.getProperty("bank"+t+"server"+(i-1)+"ip");
					if(prop.getProperty("bank"+t+"server"+(i-1)+"syncport")!=null)
					predecessor.port = Integer.parseInt(prop.getProperty("bank"+t+"server"+(i-1)+"syncport"));
					server.setPredecessor(predecessor);
					server.setSuccessor(successor);
					server.setRole(Role.NORMAL);
					server.init(Role.NORMAL);
				}
				
			}
		}
		
	}
}
