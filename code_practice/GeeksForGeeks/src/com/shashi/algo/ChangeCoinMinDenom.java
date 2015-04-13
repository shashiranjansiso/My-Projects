package com.shashi.algo;

public class ChangeCoinMinDenom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v[] = {1,2,3};
		//System.out.println(minDenom(v, 0));
		System.out.println(NoOfWays(v, 4));
	}
	
	public static int minDenom(int v[], int n)
	{
		int min = Integer.MAX_VALUE;
		if(n <= 0)
			return 0;
		else
		{
			for(int i = v.length -1; i >=0; i--)
			{
				if(v[i] <= n)
					min = Math.min(min, minDenom(v,n-v[i]));
			}
		}
		return min + 1;
	}
	
	public static int NoOfWays(int v[], int n)
	{
		int ways = 0;
		if(n< 0)
			return 0;
		if(n == 0)
			return 1;
		else
		{
			for(int i = v.length -1; i >=0; i--)
			{
				if(v[i] <= n)
					ways = ways + NoOfWays(v, n-v[i]);
			}
		}
		return ways;
	}
}
