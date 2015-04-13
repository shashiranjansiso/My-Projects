package com.shashi.algo;

public class KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("max sum is ");
		System.out.println(findMaxSum(a));
	}
	
	public static int findMaxSum(int a[])
	{
		int sum[] = new int[a.length];
		sum[0] = a[0];
		for(int i = 1; i < a.length; i++)
		{
			if(a[i] > 0)
			{
				if(sum[i-1] >= 0)
					sum[i] = sum[i-1] + a[i];
				else
					sum[i] = a[i];
			}
			else
			{
				if(sum[i-1] >= 0)
					sum[i] = sum[i-1];
				else
					sum[i] = Math.max(sum[i-1],a[i]);
			}
		}
		for(int i = 0; i < a.length; i++)
			System.out.println(sum[i]);
		return sum[a.length -1];
	}
	
}	
