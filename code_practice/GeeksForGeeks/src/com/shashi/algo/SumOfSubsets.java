package com.shashi.algo;

public class SumOfSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,7,10,12,15,18,20};
		System.out.println(SOS(a, a.length -1, 0, 35, ""));
	}
	
	public static int SOS(int a[], int i, int sum, int reqSum, String path)
	{
		if(sum == reqSum)
		{
			System.out.print("Path found ::: ");
			System.out.println(path);
			return 1;
		}
		if(i < 0 && sum != reqSum)
		{
			//System.out.print("No correct::  =>");
			//System.out.println(path);
			return 0;
		}
		return SOS(a, i-1, sum, reqSum, path) + SOS(a, i-1, sum+a[i], reqSum, path + " " + a[i]);
	}

}
