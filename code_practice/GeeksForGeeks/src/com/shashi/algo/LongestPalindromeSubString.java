package com.shashi.algo;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "rofgeeksskeegfor";
		//System.out.println(LP(str.toCharArray(), 0, str.length() -1, 0));
		steps(5, "");
	}

	public static int LP(char a[], int i, int j, int max)
	{
		if(i == j)
			return max+1;
		if(j == i+1)
		{
			if(a[i] == a[j])
				return max+2;
			else 
				return 1;
		}
		if(a[i] == a[j])
			return LP(a, i+1, j-1, max+2);
		else
			return Math.max(LP(a, i+1, j, 0), LP(a, i, j-1, 0));
	}
	
	public static int steps(int n, String path)
	{
		if(n == 0)
		{
			System.out.println(path);
			return 1;
		}
		if(n < 0)
		{
			return 0;
		}
		return steps(n-1, path + " 1 ") + steps(n-2, path + " 2 ");
	}
	
}
