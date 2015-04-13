package com.shashi;
/*
 * 
 * http://www.geeksforgeeks.org/rearrange-given-array-place/
 * Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.

Examples:

Input: arr[]  = {3, 2, 0, 1}
Output: arr[] = {1, 0, 3, 2}

Input: arr[] = {4, 0, 2, 1, 3}
Output: arr[] = {3, 4, 2, 0, 1}

Input: arr[] = {0, 1, 2, 3}
Output: arr[] = {0, 1, 2, 3}
 * 
 */
public class RearangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int arr[]  = {3, 2, 0, 1} ;
		rearrangeArray(arr);
		printArray(arr);
		*/
		/*int arr[]  = {4, 0, 2, 1, 3} ;
		rearrangeArray(arr);
		printArray(arr);*/
		int arr[]  = {0, 1, 2, 3} ;
		rearrangeArray(arr);
		printArray(arr);
	}
	public static void printArray(int[] a)
	{
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}
	
	public static void rearrangeArray(int a[])
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			a[i] = a[a[i]]*n + a[i];
		}
		for(int i = 0; i<n;i++)
		{
			a[i] = a[i]/n;
			a[i] = a[i]%n;
		}
	}

}
