package com.careercup.facebookinterviewquestions;

public class SmalletstSubaaraywithSumGreaterThanX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		int x = 280;
		findArray(arr, x);
	}

	public static void findArray(int a[], int x)
	{
		int j =0;
		int i = 0;
		int minLen = Integer.MAX_VALUE;
		int min_i = 0;
		int min_j = 0;
		int sum = 0;
		while(j<a.length)
		{
			
			while(j<a.length && sum <= x)
			{
				sum+=a[j];
				j++;
			}
			while(sum>x)
			{
				sum-=a[i];
				i++;
			}
			if(j-i+2 < minLen)
			{
				min_i = i-1;
				min_j = j-1;
				minLen = min_j - min_i + 1;
			}
		}
		System.out.println("min_i : " + min_i + "  min_j: " + min_j + "  len: " + minLen);
	}
	
}
