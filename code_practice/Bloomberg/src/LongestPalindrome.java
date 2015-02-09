
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "GEEKSFORGEEKS";
		char[] a = s.toCharArray();
		System.out.println(lps(a, 0, a.length - 1));
	}

	public static int lps(char[] s, int i, int j)
	{
		if(i==j)
			return 1;
		if(s[i] == s[j] && j == i+1)
			return 2;
		if(s[i] == s[j])
			return lps(s,i+1,j-1) + 2;
		return Math.max(lps(s,i+1,j), lps(s,i,j-1));
	}
	
}
