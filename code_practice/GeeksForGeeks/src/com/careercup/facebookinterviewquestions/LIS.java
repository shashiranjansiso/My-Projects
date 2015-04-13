package com.careercup.facebookinterviewquestions;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10,22,9,33,21,50,41,60,80};
		//System.out.println(LIS1(a, 1, a[0]));
		System.out.println(LISMemoization(a));
	}
	
	public static int LIS1(int a[], int index, int prev)
	{
		if(index >= a.length)
			return 0;
		if(a[index] > prev)
			return Math.max(1 + 	LIS1(a, index + 1, a[index]), LIS1(a, index + 1, prev));
		return LIS1(a, index + 1, prev);
	}
	
	public static int LISMemoization(int a[])
	{
		int LIS[] = new int[a.length];
		LIS[0] = 1;
		int max = 1;
		int finalMax = 1;
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(a[i] > a[j] && LIS[j] > max)
					max = LIS[j];
			}
			LIS[i] = max + 1;
			if(max > finalMax)
				finalMax = max;
		}
		return finalMax;
	}
	
}
