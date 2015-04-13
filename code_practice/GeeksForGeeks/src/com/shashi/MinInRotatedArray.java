package com.shashi;

public class MinInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {1,2,3,4,5,6,7};
		//int a[] = {7,6,5,4,3,2,1};
		//int a[] = {7,1,2,3,4,5,6};
		//int a[] = {6,7,1,2,3,4,5};
		//int a[] = {5,6,7,1,2,3,4};
		//int a[] = {4,5,6,7,1,2,3};
		//int a[] = {3,4,5,6,7,1,2};
		int a[] = {2,3,4,5,6,7,1};

		System.out.println(min(a, 0, a.length -1));
	}
	
	public static int min(int a[], int l, int h)
	{
		int mid = l + (h -l)/2;
		if(mid == h)
			return a[mid];
		if(a[mid] < a[mid+1] &&				//if mid is the smallest element
				a[mid] < a[mid -1])
			return a[mid];
		if(a[mid] > a[l] && a[mid] < a[h])		//already sorted in ascending order
			return a[l];	
		if(a[mid] > a[h] && a[mid] < a[l])		//already sorted in descending order
			return a[h];
		if(a[mid] > a[h])					//right half has smallest
				return min(a, mid+1, h);
		else
				return min(a, l, mid -1);
	}
}
