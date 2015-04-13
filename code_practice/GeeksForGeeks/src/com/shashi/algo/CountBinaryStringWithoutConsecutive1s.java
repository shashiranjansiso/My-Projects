package com.shashi.algo;

public class CountBinaryStringWithoutConsecutive1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(3));
	}
	
	public static int count(int N)
	{
		if(N == 0)
			return 0;
		int a[] = new int[N];	//count ending with 0
		int b[] = new int[N];	//count ending with 1
		a[0] = 1;
		b[0] = 1;
		for(int i = 1; i < N; i++)
		{
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
 		}
		return a[N-1] + b[N-1];
	}
	
}
