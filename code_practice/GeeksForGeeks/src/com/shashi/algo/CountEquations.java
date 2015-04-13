package com.shashi.algo;

public class CountEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,3,5,1,1};
		String path = a[a.length -2] + "";
		System.out.println(count(a, a.length -3, a[a.length -2], path));
	}

	public static int count(int a[], int i , int sum, String path)
	{
		if(i == -1)
		{
			if(sum == a[a.length -1])
			{
				System.out.println(path);
				return 1;
			}
			else
				return 0;
		}
		return count(a, i-1, sum + a[i], path + "+"+a[i]) + count(a, i-1, sum - a[i], path + "-" + a[i]);
	}
	
}
