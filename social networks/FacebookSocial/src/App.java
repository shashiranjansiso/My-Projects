import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Set;

import com.shashi.excel.AddMutualFriendToExel;


public class App {

	public static String authToken = null;
	public static String userID = /*"100001679260122"*/"1546916429";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = truncate("/**/ FB.__globalCallbacks.f747f427bf08c6({:[{");
		//authToken = "CAAGnQVmIP3kBAMvM211mcz2DxJgzgB7hJxD5ra7vuoZCBZCvMFwESQXt6HyFs7WYXXj1rxisuGTKQO3tJXDQYZAWasZAhbLPMa4nKdb5t6nA6ymKTLWRVw1rCKU8cjz3ZCnIIkHNrlxgo04JIVaAc5xhi6165ZAxO8aUcxti6inC6zs3AsjdwTkL7rh8CZAzZAZBwH1KtwTV5CneJBntVC65sWgJSS5FOMZBoZD";
		
		authToken = "CAAGnQVmIP3kBALuwttB8z0dRHVSjVmynurSnAMmBHTvIB9u525gXBbuR1Y0G0pW1Y4q2DQaOGW7TKMhMn3ZCqbeDzl3W8YmCnOh4S9Fhj1lMwZAZB1xvTxx69I6wetu7BZBjZBqx2m9yuRvp5M7zsBRx0m6bbWZCq75QselQby6C2DMydIrltjMgzuWHYfqRBZCWyOqj7Q2ZB9a3N4zaPBToV4KPPZBrhtWAZD";
		//String mutualFriendListURL = "https://graph.facebook.com/618511146/mutualfriends?access_token=" +  authToken  + "&callback=FB.__globalCallbacks.f392b6dbbf3a72&limit=200&method=get&pretty=0&sdk=joey";
		//mudit
		//String friendListURL = "https://graph.facebook.com/100000773450264/friends?access_token=" +  authToken  + "&callback=FB.__globalCallbacks.f747f427bf08c6&limit=200&method=get&pretty=0&sdk=joey";
		String friendListURL = "https://graph.facebook.com/" + userID + "/friends?access_token=" +  authToken  + "&callback=FB.__globalCallbacks.f747f427bf08c6&limit=700&method=get&pretty=0&sdk=joey";
		
		//String friendListURL = "https://graph.facebook.com/100000773450264/friends?access_token=CAAGnQVmIP3kBAECNQ5h1PqpZARBZCuLJi9FMQg60UQWBDB5ZAW3iocxYQkPmVxlouWUZB1YuQL8LZBNIhw25SC9qhy0p95jH14IpTnfrZAMlm5tUsqrVgS6xJ6XtfEplKDqMftZA6ZBBo7Tgp7hCpD26YZA3hxR2lkSbJBYaxx0ITlPiR1OI2QydWEGybEUWZBYw8KffJc5eOxcFhvh9gT4XXC&callback=FB.__globalCallbacks.f747f427bf08c6&limit=20&method=get&pretty=0&sdk=joey";
		//System.out.println(callURL(friendlistURL));
		callURL(friendListURL, "friends");
		HashMap<String, String> friendList = FbDataParser.getFriendIDMap("friends");
		getMutualFriends(friendList);
		AddMutualFriendToExel.getInstance().closeWorkBook(); 
		writeToFile("abc");
	}

	public static void writeToFile(String fileName)
	{
		// The name of the file to open.
        String file = "AdjacencyMatrix.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
           System.out.println("adj size is " + adj[0].length);
            for(int i = 0;i < adj[0].length; i++)
    		{
    			for(int j = 0;j < adj[0].length; j++)
    				bufferedWriter.write(adj[i][j] + "  ");
    			bufferedWriter.newLine();
    		}
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
		return;
	}
	
	public static void initializeMatrix()
	{
		for(int i = 0 ; i < adj[0].length ; i++)
		{
			for(int j = 0 ; j < adj[0].length; j++)
			{
				adj[i][j] = 0;
			}
		}
		for(int i = 0 ; i < adj[0].length ; i++)
		{
			adj[i][0] = 1;
			adj[0][i] = 1;
		}
	}
	
	public static int adj[][];
	public static HashMap<String, Integer> adjIndexMapWithId = new HashMap<String, Integer>();
	public static void getMutualFriends(HashMap<String, String> friendList)
	{
		if(friendList == null)
			return;
		String url;
		
		Set<String> friends = friendList.keySet();
		System.out.println("total friends are " + friendList.size());
		adj = new int[friends.size() + 1][friends.size() + 1];
		initializeMatrix();
		
		
		int count = 1;
		for (String friend : friends) {
			adjIndexMapWithId.put(friend, count++);
		}
		count = 1;
		for (String friend : friends) {
			//adjIndexMapWithId.put(friendList.get(friend), count);
			System.out.println("fetching #" + count + "    mutual friend for " + friend);
			url = "https://graph.facebook.com/" + friendList.get(friend)  + "/mutualfriends?access_token=" + authToken +"&callback=FB.__globalCallbacks.f392b6dbbf3a72&limit=300&method=get&pretty=0&sdk=joey";
			callURL(url, friend);
			HashMap<String, String> mutualfriendList  = FbDataParser.getFriendIDMap(friend);
			Set<String> mutuals = mutualfriendList.keySet();
			//if(mutuals != null)
			//{
				int i = 0;
				String mutualFriendArray[] = new String[mutuals.size()];
				for (String mutual : mutuals) {
					mutualFriendArray[i++] = mutual;
					adj[count][adjIndexMapWithId.get(mutual)] = 1;
				}
				AddMutualFriendToExel.getInstance().addMutualFriend(friend, mutualfriendList);
			//}
				count++;
		}
		//printMatrix();
		System.out.println("Done .....");
	}
	
	public static void printMatrix()
	{
		System.out.println("adjacency Matrix is ");
		for(int i = 0;i < adj[0].length; i++)
		{
			for(int j = 0;j < adj[0].length; j++)
				System.out.print(adj[i][j]+ "  ");
			System.out.println();
		}
	}
	
	public static String callURL(String url, String fname)
	{
		StringBuilder sb = new StringBuilder();
		URLConnection urlconn = null;
		InputStreamReader in = null;
		
		
		try {
			URL myUrl = new URL(url);
			urlconn = myUrl.openConnection();
			if(urlconn != null)
			{
				urlconn.setReadTimeout(60000);
			}
			if(urlconn != null && urlconn.getInputStream() != null)
			{	
				in = new InputStreamReader(urlconn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if(bufferedReader != null)
				{
					
					int cp;
					while((cp = bufferedReader.read()) != -1)
					{
						sb.append((char)cp);
					}
					bufferedReader.close();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fname + ".json";
		BufferedWriter bufferedWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			bufferedWriter =
	                new BufferedWriter(fileWriter);
			String str = sb.toString();
			 bufferedWriter.write(truncate(str));
			 bufferedWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println("friendlist found ...");
		return sb.toString();
	}
	
	public static String truncate(String str)
	{
		int i = str.indexOf("/**/");
		int end = str.indexOf("({");
		String abc = str.substring(i, end + 1);
		//System.out.println(abc);
		str = str.replace(");", "");
		return str.replace(abc, "");
	}
	
}
