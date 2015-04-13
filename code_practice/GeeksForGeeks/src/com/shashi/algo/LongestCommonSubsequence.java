package com.shashi.algo;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = /*"ABCDGH"*/"AGGTAB";
		String s2 = /*"AEDFHR"*/ "GXTXAYB";
		//System.out.println(LCS(s1.toCharArray(), s2.toCharArray()));
		System.out.println(recursiveLCS(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length() -1));
	}
	
	public static int LCS(char a[], char b[])
	{
		int m[][] = new int[a.length +1][b.length+1];
		for(int i = 0; i <a.length+1; i++)
		{
			m[i][0] = 0;
		}
		for(int j = 0; j <b.length+1; j++)
		{
			m[0][j] = 0;
		}
		for(int i = 1; i <a.length+1; i++)
		{
			for(int j = 1; j <b.length+1; j++)
			{
				if(a[i-1] == b[j-1])
					m[i][j] = 1+m[i-1][j-1];
				else
					m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
			}
		}
		for(int i = 0; i <a.length+1; i++)
		{
			for(int j = 0; j <b.length+1; j++)
			{
				//System.out.println(m[i][j]);
			}
		}

		return m[a.length][b.length];
	}
	
	public static int recursiveLCS(char a[], char b[], int i, int j)
	{
		if(i < 0 || j < 0)
			return 0;
		if(a[i] == b[j])
			return 1 + recursiveLCS(a, b, i-1, j-1);
		else
			return Math.max(recursiveLCS(a, b, i-1, j), recursiveLCS(a, b, i, j-1));
	}
}
