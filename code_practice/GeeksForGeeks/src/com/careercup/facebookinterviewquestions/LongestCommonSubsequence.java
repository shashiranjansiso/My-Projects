package com.careercup.facebookinterviewquestions;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		//System.out.println(LCS(s1.toCharArray(), s2.toCharArray(), s1.length() -1, s2.length() -1));
		System.out.println(LCSUsingMemoization(s1.toCharArray(), s2.toCharArray()));
	}
	
	public static int LCS(char a[], char b[], int i, int j)
	{
		if(i < 0 || j < 0)
			return 0;
		if(a[i] == b[j])
			return 1 + LCS(a, b, i-1, j-1);
		return Math.max(LCS(a, b, i-1, j), LCS(a, b, i, j-1));
	}

	public static int LCSUsingMemoization(char a[], char b[])
	{
		int m[][] = new int [a.length+1][b.length + 1];
		int max = 0;
		for(int i = 0; i < a.length +1; i++)
		{
			for(int j = 0; j < b.length +1; j++)
			{
				if(i ==0 || j ==0)
					m[i][j] = 0;
				else if(a[i-1] == b[j-1])
				{
					System.out.println(a[i-1]);
					m[i][j] = 1 + m[i-1][j-1];
				}
				else
					m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
				if(m[i][j] > max)
					max = m[i][j];
			}
		}
		for(int i = 0; i < a.length +1; i++)
		{
			for(int j = 0; j < b.length +1; j++)
			{
				System.out.print(m[i][j] + "   ");
			}
			System.out.println();
		}
		return max;
	}
	
}
