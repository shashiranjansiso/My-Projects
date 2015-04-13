package com.careercup.facebookinterviewquestions;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
		System.out.println(findFirstRepeating(arr));
	}

	
	public static int findFirstRepeating(int arr[])
	{
	    Set<Integer> set = new HashSet<Integer>();
	    int min = arr.length + 2;
	    for(int i = arr.length -1; i >=0; i--)
	    {
	        if(!set.contains(arr[i]))
	            set.add(arr[i]);
	        else
	        {
	            //repeated
	            if(i < min)
	                min = i;
	        }        
	    }
	    return arr[min];
	}
}
