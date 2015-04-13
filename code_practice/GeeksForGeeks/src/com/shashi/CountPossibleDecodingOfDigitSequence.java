package com.shashi;
/*
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * 
 */
public class CountPossibleDecodingOfDigitSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4};
		System.out.println(count(a, a.length));
	}

	public static int count(int a[], int i)
	{
		if(i <= 1)
			return 1;
		int count = 0;
		if(a[i-1] > 0)	
			count = count(a, i-1);
		//if(a[i] < 7 && (a[i -1 ] == 1 || a[i-1] == 2))
		if(a[i-2] < 2 || (a[i -2 ] == 2 && a[i-1] < 7))
		{
			count = count + count(a, i-2);
		}
		return count;
	}
	
}
