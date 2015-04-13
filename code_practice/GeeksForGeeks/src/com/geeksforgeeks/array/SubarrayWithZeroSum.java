package com.geeksforgeeks.array;

import java.util.HashSet;
import java.util.Set;
/*
 * 
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 */
public class SubarrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4, 2, -3, 1, 6};
		System.out.println(isZeroSum(a));
		int b[]= {4, 2, 0, 1, 6};
		System.out.println(isZeroSum(b));
		int c[]= {-3, 2, 3, 1, 6};
		System.out.println(isZeroSum(c));
	}

	public static boolean isZeroSum(int a[])
	{
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for(int i = 0; i < a.length;i++)
		{
			sum+=a[i];
			if(set.contains(sum))
				return true;
			else
				set.add(sum);
		}
		return false;
	}
	
}
