package com.careercup.facebookinterviewquestions;

public class IsSumPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,5,23,2};
		System.out.println(isPossible(a, 7));
	}

	public static boolean isPossible(int a[], int T)
	{
		int i = 0; int j = 0;
		int sum = 0;
		while(i < a.length)
		{
			if(a[i]>T)
			{
				sum = 0; 
				j=i+1;
				i++;
			}
			if(sum < T)
			{
				sum+=a[i];
				i++;
			}
			while(sum > T)
			{
				sum-=a[j];
				j++;
			}
			if(sum == T)
				return true;
		}
		return false;
	}
	
}
