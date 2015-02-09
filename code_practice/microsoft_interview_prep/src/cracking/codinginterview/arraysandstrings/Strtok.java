package cracking.codinginterview.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class Strtok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello|world|and|Youtube";
		List<String> tokenArr = strtok(str, '|');
		for (String token : tokenArr) {
			System.out.println(token);
		}
	}
	
	public static List<String> strtok(String str, char delimiter)
	{
		int startIndex = 0; 
		int endIndex;
		List<String> ans = new ArrayList<String>();
		char[] charArr = str.toCharArray();
		for(int i = 0; i< str.length(); i++)
		{
			if(charArr[i] == delimiter)
			{
				endIndex = i;
				ans.add(str.substring(startIndex, endIndex));
				startIndex = endIndex + 1;
			}
		}
		ans.add(str.substring(startIndex));
		return ans;
	}
}
