package com.shashi;

/*
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 * Examples:
 * arr[] = {1, 4, 45, 6, 0, 19}
 * x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 */

public class SmallestSubArraySumGreaterThanGivenValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {1, 4, 45, 6, 0, 19};
		int arr2[] = {1, 10, 5, 2, 7};
		System.out.println(smalltestSubArray(arr2, 9));
		int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		System.out.println(smalltestSubArray(arr3, 280));
	}
	
	public static int smalltestSubArray(int a[], int sum)
	{
		int currSum = 0;
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while(j<a.length)
		{
			while(sum>=currSum)
			{
				currSum += a[j++];
			}
			while(currSum>sum)
			{
				currSum-=a[i++];
			}
			if(j-i+1 < min)
			{
				min = j-i+1;
			}
		}
		return min;
	}

}
