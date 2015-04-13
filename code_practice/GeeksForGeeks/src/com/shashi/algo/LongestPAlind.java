package com.shashi.algo;

public class LongestPAlind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcdefghihgh";
		System.out.println(LP(a.toCharArray(), 0, a.length() -1));
	}
	
	public static int LP(char a[], int s, int e)
	{
		if(e == s)
			return 1;
		if(e == s+1)
		{
			if(a[e] == a[s])
				return 2;
			else 
				return 1;
		}
		if(a[s] == a[e])
			return 2 + LP(a, s+1, e-1);
		else
			return Math.max( LP(a, s+1, e-1), Math.max(LP(a, s+1, e),  LP(a, s, e-1)));
	}
}
