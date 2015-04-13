package com.shashi;

public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void sort(int a[])
	{
		int len = a.length;
		if(len == 0)
			return;
		int l = 0, m = 0;
		int h = len -1;
		while(m < h)
		{
			if(a[m] == 1)
				m++;
			if(a[m] == 0)
			{
				swap(a, l,m);
				m++;l++;
			}
			if(a[m] == 2)
			{
				swap(a, m , h);
				h--;
			}
		}
	}
	
	public static void swap(int a[], int i, int j)
	{
		
	}
	
}
