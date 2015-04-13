package com.shashi;
/*
 * http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 * 
 * Given two sorted arrays such the arrays may have some common elements. 
 * Find the sum of the maximum sum path to reach from beginning of any array 
 * to end of any of the two arrays. We can switch from one array to another array 
 * only at common elements.
 */
public class MaxSumPathTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[]  = {2, 3, 7, 10, 12, 15, 30, 34};
	    int ar2[] =  {1, 5, 7, 8, 10, 15, 16, 19};
	    System.out.println(MaxSumPath(ar1, ar2));
	}
	
	public static int MaxSumPath(int a[], int b[])
	{
		int i = 0, j = 0;
		int sum = 0, sum1 = 0, sum2 = 0;
		while(i < a.length && j < b.length)
		{
			if(a[i] < b[j])
			{
				sum1+= a[i]; i++;
			}
			else if(a[i] > b[j])
			{
				sum2+= b[j]; j++;
			}
			else if(a[i] == b[j])
			{
				sum1+=a[i];
				sum2+=b[j];
				if(sum1>sum2)
					sum+= sum1;
				else
					sum+=sum2;
				sum1= sum2= 0;
				i++;j++;
			}
		}
		while(i<a.length)
		{
			sum1+= a[i];i++;
		}
		while(j<b.length)
		{
			sum1+= b[j];j++;
		}
		if(sum1>sum2)
			sum+= sum1;
		else
			sum+=sum2;
		return sum;
	}

}
