package com.shashi;

public class MoveZeroesAtEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		moveZeroEnd(a);	
		printArray(a);
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}
	
	public static void moveZeroEnd(int a[])
	{
		int n = a.length;
		int zc = 0;
		for(int i = 0; i < n; i++)
		{
			if(a[i] != 0){
				a[i-zc] = a[i];
				if(zc > 0)
					a[i] = 0;
			}
			else
				zc++;
		}
	}

}
