package com.careercup.facebookinterviewquestions;
/*
 * 
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 */
public class FindTwoRepeatingElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4, 2, 4, 5, 2, 3, 1};
		find(a);
	}

	public static void find(int a[])
	{
		for(int i = 0; i < a.length; i++)
		{
			
		    if(a[Math.abs(a[i])] < 0)
		        System.out.println("repeated element " + i);
		    else
		       a[Math.abs(a[i])] = -1*a[Math.abs(a[i])];   
		}       
	}
	
	
	
}
