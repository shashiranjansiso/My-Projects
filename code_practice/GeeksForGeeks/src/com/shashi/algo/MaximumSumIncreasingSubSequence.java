package com.shashi.algo;

/*Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence 
of the given array such that the intgers in the subsequence are sorted in increasing order. 
For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and 
if the input array is {10, 5, 4, 3}, then output should be 10   */

public class MaximumSumIncreasingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 101, 2, 3, 100, 4, 5};
		int b[] = {3, 4, 5, 10};
		int c[] = {10, 5, 4, 3};
		System.out.println(increasingSubSequence(a, a.length -1, 0, Integer.MAX_VALUE));
	}
	
	public static int increasingSubSequence(int a[], int i, int sum, int prevMax)
	{
		if(i < 0)
			return sum;
		if(a[i] < prevMax)
		{
			return Math.max(increasingSubSequence(a, i-1, sum + a[i], a[i]), increasingSubSequence(a, i-1, sum, prevMax));
		}
		else
			return increasingSubSequence(a, i-1, sum, prevMax);
	}
}
