package com.careercup.facebookinterviewquestions;

import java.util.HashMap;

/*
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 * 
 */
public class DuplicateAtKDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5};
		System.out.println(isPossible(arr, 3));
	}
	
	public static boolean isPossible(int a[], int k)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < a.length; i++)
		{
			if(map.containsKey(a[i]))
			{
				int j = map.get(a[i]);
				int d = i-j;
				if(d <= k)
					return true;
			}
			map.put(a[i], i);
		}
		return false;
	}

}
