package com.geeksforgeeks.array;
/*
 * KADANE algorithm
 * http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
 */
public class MaxSumSubarrayKadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2, -5, 6, -2, -3, 1, 5, -6};
		System.out.println(MaxSumSubArray(a));
	}
	
	public static int MaxSumSubArray(int a[])
	{
		if(a.length == 0)
			return 0;
		int currSum = a[0];
		int maxSum = a[0];
		for(int i = 1; i < a.length; i++)
		{
			currSum = Math.max(a[i], a[i] + currSum);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

}
