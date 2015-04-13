package com.geeksforgeeks.array;

/*
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 */
public class MaxProductSubarrayKadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {6, -3, -10, 0, 2};
		System.out.println(maxProduct(a));
	}
	
	public static int maxProduct(int a[])
	{
		int maxSofar = Integer.MIN_VALUE;
		int maxP = 1;
		int maxN = 1;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == 0)
			{
				maxP = maxN = 1;
			}
			else if(a[i] > 0)
			{
				maxP = maxP * a[i];
				maxN = Math.min(1,  maxN * a[i]);
			}
			else
			{
				maxP = Math.max(maxP, maxN*a[i]);
				maxN = Math.min(maxP*a[i], 1);
			}
			if(maxP > maxSofar)
				maxSofar = maxP;
		}
		return maxSofar;
	}

}
