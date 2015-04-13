package com.careercup.facebookinterviewquestions;

public class MinJumpsRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//int arr[] = {1, 3, 5};
		System.out.println(jumpsReq(arr, 0));
	}
	
	public static int jumpsReq(int a[], int i)
	{
		if(i >= a.length)
			return 10000;
		if(a[i] == 0)
			return 10000;
		if(i == a.length -1)
			return 0;
		int min = 10000;
		for(int k = 1 ; k <= a[i]; k++)
		{
			int steps = jumpsReq(a, i+k) + 1;
			if(steps < min)
				min = steps;
		}
		return min;
	}

}
