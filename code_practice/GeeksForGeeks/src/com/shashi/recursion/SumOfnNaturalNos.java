package com.shashi.recursion;

public class SumOfnNaturalNos {
	public static void main(String[] args) {
		System.out.println(sumOfNatural(0, 0, 100));
	}
	
	public static int sumOfNatural(int i, int sum, int n)
	{
		if(i > n)
			return sum;
		return sumOfNatural(i+1, sum + i, n);
	}

}
