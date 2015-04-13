package com.shashi;

public class FivesAtTheEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void arrangeArray(int a[])
	{
		if(a.length <= 1)
			return;
		int i=0, j=0;
		while(j<a.length)
		{
			if(a[j] == 5)
			{
				swap(a,i,j);
				i++;j++;
			}
		}
	}
	public static void swap(int a[], int i, int j)
	{
		
	}
	
}
