package com.careercup.facebookinterviewquestions;

/*
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * 
 */
public class findSpecificSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 4};
		findSubArray(arr, 0);
	}

	public static void findSubArray(int a[], int x)
	{
		int i =0 ;
		int j = 0;
		int sum = 0;
		int start = -1; 
		int end = -1;
		while(i < a.length)
		{
			if(sum < x)
			{
				sum+= a[i];
				i++;
			}
			if(sum > x)
			{
				sum-=a[j];
				j++;
			}
			if(sum == x)
			{
				start = j;
				end = i-1;
				break;
			}
		}
		if(start != -1 && end != -1)
		{
			System.out.println("start pos is " + start + "  end position is " + end);
		}
		else
		{
			System.out.println("No subArray found ...");
		}
	}
	
}
