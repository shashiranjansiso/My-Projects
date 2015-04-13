package com.careercup.facebookinterviewquestions;

public class MaxSumSuchThatNoTwoElementsAreAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3, 2, 5, 10, 7};
		System.out.println(MS(a, a.length -1, 0));
	}

	public static int MS(int a[], int i, int sum)
	{
		if(i < 0)
			return sum;
		return Math.max(MS(a, i-2, sum + a[i]), MS(a, i-1, sum));
	}
	
}
