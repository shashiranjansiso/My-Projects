package com.careercup.facebookinterviewquestions;

public class QSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,10,5,7,3,6};
		qsort(a, 0, a.length-1);
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
	
	public static int partition(int a[], int l, int h)
	{
		int i = l; int j = h-1;
		while(i<=j)
		{
			if(a[i] > a[h] && a[j] < a[h])
			{
				swap(a, i, j);
				i++;
				j--;
			}
			if(a[i] < a[h])
				i++;
			if(a[j] > a[h])
				j--;
			
		}
		swap(a, i, h);
		return i;
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void qsort(int a[], int l, int h)
	{
		if(l<h)
		{
			int p = partition(a, l, h);
			qsort(a, l, p-1);
			qsort(a, p+1, h);
		}
	}

}
