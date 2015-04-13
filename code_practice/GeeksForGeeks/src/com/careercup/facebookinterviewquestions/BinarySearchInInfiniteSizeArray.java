package com.careercup.facebookinterviewquestions;

public class BinarySearchInInfiniteSizeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		System.out.println(search(arr, 0, 170));
	}
	
	public static int bsearch(int a[], int l,int h, int n)
	{
		int mid = (l + h)/2;
		if(a[mid] == n)
			return mid;
		if(n > a[mid])
			return bsearch(a, mid+1, h, n);
		return bsearch(a, l, mid-1, n);
	}
	
	public static int search(int a[], int pow, int n)
	{
		int index = (int) Math.pow(2, pow);
		if(index >= a.length)
		{
			int l = (int) Math.pow(2, pow-1);
			int h = a.length;	
			return bsearch(a, l, h-1, n);
		}
		if(a[index] == n)
			return index;
		if(n > a[index])
			return search(a, pow+1, n);
		else
		{
			int l = (int) Math.pow(2, pow-1);
			int h = (int) Math.pow(2, pow);
			return bsearch(a, l, h-1, n);
		}
	}

}
