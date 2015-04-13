package com.careercup.facebookinterviewquestions;

public class FillTwoInstancesOfNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArray(4);
	}
	
	public static void printArray(int n)
	{
		int a[] = new int[2*n];
		if(fill(a, n))
		{
			for(int i = 0; i < a.length; i++)
				System.out.print(a[i] + "  ");
		}
		else
			System.out.println("Not possible");
	}
	
	public static boolean fill(int a[], int n)
	{
		if(n == 0)
			return true;
		for(int i = 0; i < a.length; i++)
		{
			if(isSafe(a, i, i + 1 + n))
			{
				a[i] = n;
				a[i + 1 + n] = n;
				if(fill(a, n-1))
					return true;
				a[i] = 0;
				a[i+1+n] = 0;
			}
		}
		return false;
	}
	
	public static boolean isSafe(int a[], int i, int j)
	{
		if(i >= a.length || j >= a.length)
			return false;
		if(a[i] != 0 || a[j] != 0)
			return false;
		return true;
	}

}
