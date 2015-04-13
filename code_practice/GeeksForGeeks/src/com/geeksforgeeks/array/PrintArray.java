package com.geeksforgeeks.array;

public class PrintArray {
	public static void printArray(int a[])
	{
		for(int i = 0; i < a.length;i++)
			System.out.print(a[i] + "  ");
	}
	
	public static void swap(int a[], int i, int j)
	{
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}
}
