package cracking.codinginterview.arraysandstrings;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefg";
		String str2 = "bcdefgh";
		if(isPermutation(str1, str2))
			System.out.println("yes");
		else
			System.out.println("No");
	}
	
	public static boolean isPermutation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		int i; boolean flag = false;
		for(i = 0; i <str1.length() ; i++)
		{
			if(str1.charAt(0) == str2.charAt(i))
			{
				flag = true;
				break;
			}
			else
				continue;
		}
		if(!flag)
			return false;
		else
			return compare(str1, str2, i);
	}
	
	public static boolean compare(String str1, String str2, int from)
	{
		int index2;
		for(int i = 0; i< str1.length(); i++)
		{
			index2 = from + i;
			if(index2 >= str1.length())
				index2 = index2 - str1.length();
			if(str1.charAt(i) != str2.charAt(index2))
				return false;
		}
		return true;
	}
}
