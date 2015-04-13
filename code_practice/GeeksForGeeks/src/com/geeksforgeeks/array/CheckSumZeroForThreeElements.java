package com.geeksforgeeks.array;

public class CheckSumZeroForThreeElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10, -2, -2};
		System.out.println(check(a, 0, 0, 0));
	}
	
	public static boolean check(int a[], int i, int c, int sum)
	{
		if(sum == 0 && c == 3)
			return true;
		if(i >= a.length)
			return false;
		if(c > 3)
			return false;
		return check(a, i + 1, c + 1, sum + a[i]) || check(a,  i+ 1, c, sum) || check(a, i, c + 1, sum - a[i]);
	}

}
