package com.careercup.facebookinterviewquestions;

public class MaximumIncreasingSumSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {1, 101, 2, 3, 100, 4, 5};
		System.out.println(IS(a, 0, 0, -1));
	}

	public static int IS(int a[], int i, int sum, int prev)
	{
		if(i >= a.length)
			return sum;
		if(a[i] < prev)
			return IS(a, i+1, sum, prev);
		else
			return Math.max(IS(a, i+1, sum + a[i], a[i]), IS(a, i+1, sum, prev));
	}
	
}
