package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		char[] sArray = s.toCharArray(); 
		char[] b = new char[sArray.length];
		List<String> permutation = new ArrayList<String>();
		doPermutation(s.toCharArray(), b, 0, permutation);
		/*for (String string : perm) {
			System.out.println(string);
		}*/
		
	}
	
	

	public static void doPermutation(char[] s, char[] b, int index, List<String> list)
	{
		if(index == s.length)
		{
			list.add(new String(b));
			System.out.println(new String(b));
			//return null;
		}
		else
		{
			for(int i = 0; i < s.length; i++)
			{
				boolean found = false;
				for(int j = 0; j<index; j++)
				{
					if(b[j] == s[i])
					{
						found = true;
						//break;
					}
				}
				if(!found)
				{
					b[index] = s[i];
					doPermutation(s, b, index + 1, list);
				}
			}
		}
		//return list;
	}
	
}
