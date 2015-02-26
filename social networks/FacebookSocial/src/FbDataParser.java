

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FbDataParser {

	private static String filePath = "/Users/shashi/Desktop/workspace/FacebookSocial/";
	public static HashMap<String, String> getFriendIDMap(String friend)
	{
		String fpath = filePath + friend + ".json";
	//public static void main(String[] args) {
		HashMap<String, String> friendList = new HashMap<String, String>();
		//String ids[] = null;
		try {
			// read the json file
			FileReader reader = new FileReader(fpath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object
			JSONArray data = (JSONArray) jsonObject.get("data");
			if(data == null)
			{
				System.out.println("Auth Token Expired....");
				return null;
			}
			 Iterator i = data.iterator();
			System.out.println("total no of friends are " + data.size());
			
			//ids = new String[data.size()];
			//int j = 0;
			 while (i.hasNext()) {
					JSONObject innerObj = (JSONObject) i.next();
					String name = (String)innerObj.get("name");
					String friendId = (String) innerObj.get("id");
					/*System.out.println("name "+ innerObj.get("name") + 
							"		 id" + innerObj.get("id"));*/
					friendList.put(name, friendId);
					//ids[j] = (String) innerObj.get("id");
					//System.out.println("ids are  " + ids[j] + "      j is " + j);
					//j++;
				} 
			 //System.out.println("total friend found ... " + j);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
		return friendList;
	}
	
}
