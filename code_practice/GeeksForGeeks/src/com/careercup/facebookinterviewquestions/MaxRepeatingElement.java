package com.careercup.facebookinterviewquestions;

public class MaxRepeatingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
		System.out.println(maxRepeating(arr, 10));
	}

	public static int maxRepeating(int a[], int k)
	{
		int max = 0;
		for(int i = 0; i < a.length; i++)
		{
			int pos = a[i]%k;
			a[pos] = a[pos] +k;
			if(a[pos] > max)
				max = a[pos];
		}
		return max%k;
	}
	
}
