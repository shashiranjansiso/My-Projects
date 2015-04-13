package com.careercup.facebookinterviewquestions;

public class WaveSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 6, 8, 10, 20};
		sort(arr);
	}

	public static void sort(int a[])
	{
		boolean min = true;
		for(int i = 1; i < a.length -1; i++)
		{
			int f = a[i-1];
			int s = a[i];
			int t = a[i+1];
			if(min)
			{
				if(f<s)
					swap(a, i, i-1);
				else if(t < s)
					swap(a, i, i+1);
				min = false;
			}
			else
			{
				if(f>s)
					swap(a, i, i-1);
				else if(t > s)
					swap(a, i, i+1);
				min = true;
			}
		}
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + "  ");
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
