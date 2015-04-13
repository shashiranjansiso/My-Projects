package com.geeksforgeeks.array;

public class PushZerosAtTheEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		pushAtEnd(a);
		PrintArray.printArray(a);
	}

	
	public static void pushAtEnd(int a[])
	{
		int i = 0;
		int j = 0;
		while(j<a.length)
		{
			while(i < a.length && a[i] != 0)
				i++;
			j=i+1;
			while(j < a.length && a[j]==0)
				j++;
			if(j < a.length)
				swap(a,i,j);
		}
	}
	
	public static void swap(int a[], int i, int j)
	{
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

}
