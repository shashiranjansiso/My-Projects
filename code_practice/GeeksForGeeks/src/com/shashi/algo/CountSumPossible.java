package com.shashi.algo;

public class CountSumPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,34,4,12,5,2};
		System.out.println(isSumPossible(a, a.length -1, 200));
	}

	public static boolean isSumPossible(int a[], int i, int sum)
	{
		if(sum == 0)
			return true;
		if(i < 0)
			return false;
		if(sum < 0)
			return false;
		return isSumPossible(a, i-1, sum) || isSumPossible(a, i-1, sum -a[i]);
	}

}
