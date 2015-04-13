package com.shashi.algo;

public class CountWaysToReachStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(4));
	}

	public static int count(int steps)
	{
		if(steps ==0)
			return 1;
		if(steps <0)
			return 0;
		return count(steps-1) + count(steps-2);
	}
	
}
