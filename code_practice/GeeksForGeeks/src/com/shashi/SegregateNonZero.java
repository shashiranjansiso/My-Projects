package com.shashi;
/*
 * 
 * http://www.geeksforgeeks.org/amazon-interview-set-103-campus/
 * 1.	Given an array of integers. Segregate all the non-zero numbers at the beginning. Print the number of non-zero integers and the minimum number of swaps required for these operations.

Eg.  : I/p : 1, 0, 0, -6, 2, 0
         o/p : Number of non-zero integers : 3
                   Minimum number of swaps : 2 
 * 
 * 
 */
public class SegregateNonZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void print(int a[])
	{
		int i = 0; 
		int j = 0;//pointer to non zero
		while(j < a.length)
		{
			while(a[j] ==0)
				j++;
			while(a[i] != 0)
			{
				i++;
			}
			if(a[i] == 0)
			{
				
			}
		}
	}

}
