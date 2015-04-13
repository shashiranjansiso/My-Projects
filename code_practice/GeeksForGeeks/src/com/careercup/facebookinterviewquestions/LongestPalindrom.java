package com.careercup.facebookinterviewquestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GEEKS FOR GEEKS";
		//String str = "aba";
		System.out.println(LPS(str.toCharArray(), 0, str.length() -1, 0));
		System.out.println(LP(str.toCharArray()));
	}

	public static int LPS(char a[], int i, int j, int max)
	{
		if(i == j)
			return max + 1;
		if(j == i+1)
		{
			if(a[j] == a[i])
				return max + 2;
			else
				return max + 1;
		}
		if(a[i] == a[j])
			return LPS(a, i+1, j-1, max+2);
		return Math.max(LPS(a, i + 1, j, 0), LPS(a, i, j-1, 0));
	}
	public static int LP(char a[])
	{
	    int n = a.length;
	    int m[][] = new int[n][n];
	    //for length 1 palindrome
	    for(int i = 0; i <n; i++)
	        m[i][i] = 1;
	    for(int cl = 2; cl <=n; cl++)
	    {
	        for(int i = 0; i < n-cl+1; i++)
	        {
	            int  j = i+cl-1;
	            if(j==i+1 && cl ==2)
	            {
	                if(a[i] == a[j])
	                    m[i][j] = 2;
	                else
	                	m[i][j] = 1;
	            }
	            else if(a[i] == a[j])
	                m[i][j] = 2+m[i+1][j-1];
	            else
	                m[i][j] = Math.max(m[i+1][j], m[i][j-1]);    
	        }
	    }    
	    return m[0][n-1];    
	}
}
