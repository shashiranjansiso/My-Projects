package com.shashi;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNumberSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 5, 3, 6, 8, 7};
		System.out.println(count(a));
	}

	public static int count(int a[])
	{
		if(a.length == 0)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < a.length; i++)
			set.add(a[i]);
		int max = 1;
		for(int i = 0; i < a.length; i++)
		{
			int count = 1;
			int left = a[i]-1;
			int right = a[i] + 1;
			while(set.contains(left))
			{
					count++;
					left--;
			}
			while(set.contains(right))
			{
				count++;
				right++;
			}
			max = Math.max(count, max);
		}
		return max;
	}
	
}
