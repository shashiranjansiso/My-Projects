package com.shashi;

import java.util.HashMap;
/*
 * 
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * 
 */

public class DistinctPairWithDiffk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {1, 5, 3, 4, 2};
		//System.out.println(getCount(a, 3));
		int a[] = {8, 12, 16, 4, 0, 20};
		System.out.println(getCount(a, 4));
		
	}
	
	public static int getCount(int a[], int diff)
	{
		if(a.length == 0)
			return 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < a.length; i++)
		{
			int f = a[i] - diff;
			int s = a[i] + diff;
			if(map.get(f) != null)
				count++;
			if(map.get(s) != null)
				count++;
			map.put(a[i], 1);
		}
		return count;
	}

}
