package com.shashi;

/* microsoft question */

/* matrix is given in 1D array 
 * 	a[][] = {1,2,3,4,
 * 			 5,6,7,8,
 * 			 9,10,11,12,
 * 			 13,14,15,16}
 * 
 * tranpose of above matrix is 
 * b[][] = {1,5,9,13,
 * 			2,6,10,14,
 * 			3,7,11,15,
 * 			4,8,12,16
 * 			}
 * input is 
 *  in 1D array a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 *  and size of matrix ie 4*4
 *  output should be
 * 	{1,5,9,13,2,6,10,14,3,7,11,15,4,8,12,16}
 * 
 * 
 * */


public class MatrixTranspose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int b[] = transposeMatrix(a, 4);
		for(int i = 0; i < b.length; i++)
		{
			System.out.print(b[i] + "  ");
		}
		System.out.println();
	}
	public static int[] transposeMatrix(int[] a, int m)
	{
		int r, c;
		int b[] = new int[a.length];
		for(int i = 0; i < a.length; i++)
		{
			r = i/m;
			c = i%m;
			b[i] = a[c*m + r];
		}
		return b;
	}
}
