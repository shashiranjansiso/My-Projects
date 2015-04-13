package com.shashi.algo;

public class MaxLenArraySuchThatAOfJGreaterThanAOfi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		System.out.println(maxlen(a, 0, a.length-1));
	}

	public static int maxlen(int a[], int i, int j)
	{
		if(i>j)
			return 0;
		if(a[j] > a[i])
			return j-i;
		else
			return Math.max(maxlen(a, i+1, j), maxlen(a, i, j-1));
	}
	
	public static int maxLen(int a[])
	{
		int LMin[] = new int[a.length];
		LMin[0] = 0;
		int RMax[] = new int[a.length];
		RMax[a.length-1] = a.length -1;
		
		for(int i = 1; i < a.length;i++)
		{
			if(a[i] < a[LMin[i-1]])
				LMin[i] = i;
		}
		for(int i = a.length-2; i >=0 ;i--)
		{
			if(a[i] > a[RMax[i+1]])
				RMax[i] = i;
		}
		for(int i = 0; i < a.length;i++)
		{
			
		}
		return 0;
	}
	
}
