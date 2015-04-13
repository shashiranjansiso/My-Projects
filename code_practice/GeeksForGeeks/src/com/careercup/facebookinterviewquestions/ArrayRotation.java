package com.careercup.facebookinterviewquestions;

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4, 5,6,7};
		rightrotate(a, 3);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + "  ");
		}
	}

	public static void rightrotate(int a[], int k)
	{
	    int k1 = a.length -k;
	    reverse(a, 0, k1-1);
	    reverse(a, k1, a.length-1);
	    reverse(a, 0, a.length-1);
	}

	public static void reverse(int a[], int l, int h)
	{
	    for(int i = l; i <= (l+h)/2; i++)
	    {
	        swap(a, i, h-(i-l));
	    }
	}

	public static void swap(int a[], int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp; 
	}
	
}
