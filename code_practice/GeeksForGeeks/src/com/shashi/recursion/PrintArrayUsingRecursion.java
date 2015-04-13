package com.shashi.recursion;

public class PrintArrayUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7,8,9};
		printInorder(a, 0);
	}

	public static void printInorder(int a[], int i)
	{
		if(i >= a.length)
			return;
		System.out.println(a[i]);
		printInorder(a, i+1);
	}
	
}
