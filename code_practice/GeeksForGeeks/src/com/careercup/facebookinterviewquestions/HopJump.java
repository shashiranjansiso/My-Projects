package com.careercup.facebookinterviewquestions;

public class HopJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,2,1,0,4};
		System.out.println(isPossible(a, 0));
	}

	public static boolean isPossible(int a[], int i)
	{
		if(i == a.length -1)
			return true;
		if(i >= a.length)
			return false;
		boolean result = false;
		for(int k = 1; k <= a[i]; k++)
		{
			result = result || isPossible(a, i+k);
		}
		return result;
	}
	
}
