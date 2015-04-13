package com.geeksforgeeks.array;
/*
 * 
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 * 
 */
public class MaxRepeatingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
		int k = 10;
		System.out.println(maxRepeatingNumber(a, k));
		int b[] = {2, 3, 3, 5, 3, 4, 1, 7};
		int k1 = 8;
		System.out.println(maxRepeatingNumber(b, k1));
	}
	
	public static int maxRepeatingNumber(int a[], int k)
	{
		if(a.length ==0)
			return -1;
		int max = Integer.MIN_VALUE;
		int num = -1;
		for(int i = 0;i < a.length; i++)
		{
			a[a[i]%k] = a[a[i]%k] + k;
			if(a[a[i]%k] > max)
			{
				max = a[a[i]%k];
				num = a[i]%k;
			}
			
		}
			
		return num;
	}

}
