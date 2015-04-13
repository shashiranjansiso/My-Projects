package com.careercup.facebookinterviewquestions;

public class FindPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x = 50;
        find(ar1, ar2, x);
	}

	public static void find(int a[], int b[], int x)
	{
		int i = 0; 
		int j = b.length -1;
		int min_i = 0;
		int min_j = 0;
		int min = Integer.MAX_VALUE;
		while(i < a.length && j >= 0)
		{
			int d = a[i] + b[j] -x;
			if(Math.abs(d) < min)
			{
				min = Math.abs(d);
				min_i = i;
				min_j = j;
			}
			if(d > 0)
				j--;
			else
				i++;
		}
		System.out.println(" first no is " + a[min_i] + "  second no is " + b[min_j]);
	}
	
}
