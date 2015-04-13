package com.careercup.facebookinterviewquestions;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * 
 */
public class ArrayPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 3};
		System.out.println(P(arr, 0, 0, 0));
	}	
	
	public static boolean P(int a[], int i, int s1, int s2)
	{
		if(i >= a.length && s1 == s2)
			return true;
		if(i >=	 a.length && s1 != s2)
			return false;
		return P(a, i+1, s1+a[i], s2) || P(a, i+1, s1, s2+a[i]);
	}

}
