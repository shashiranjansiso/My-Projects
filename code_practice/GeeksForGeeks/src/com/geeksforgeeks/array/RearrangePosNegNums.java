package com.geeksforgeeks.array;

/*
 * 
 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 */
public class RearrangePosNegNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		rearrange(a);
		PrintArray.printArray(a);
	}

	public static void rearrange(int a[])
	{
		for(int wp = 0; wp < a.length; wp++)
		{
			if(a[wp] < 0 && wp%2 ==0) //case 1: wrong place :even and neg 
			{
				int j = wp+1;
				while(j < a.length && a[j] < 0)
					j++;
				if(j < a.length)
					PrintArray.swap(a, j, wp);
				//wp = wp+1;
			}
			if(a[wp] > 0 && wp%2 != 0)	//case 2: wrong place : odd and pos
			{
				int j = wp+1;
				while(j < a.length && a[j] > 0)
					j++;
				if(j < a.length)
					PrintArray.swap(a, j, wp);
				//wp = wp+1;
			}
		}
	}
	
}
