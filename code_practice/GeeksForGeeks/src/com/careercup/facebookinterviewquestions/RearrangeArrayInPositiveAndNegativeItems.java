package com.careercup.facebookinterviewquestions;

/*
 * http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 */
public class RearrangeArrayInPositiveAndNegativeItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, -4, -1, 4};
		rearrage(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
	}

	public static void rearrage(int a[])
	{
		int i =0;
		while(i<a.length)
		{
			if(i%2 ==0 && a[i] >0)
			{
				int j = i+1;
				//find neg
				for(j=i+1; j <a.length; j++)
				{
					if(a[j] < 0)
						break;
				}
				if(j == a.length)
					return;
				else
				{
					int neg = a[j];
					for(int k = j; k >i; k--)
						a[k] = a[k-1];
					a[i] = neg;
				}
			}
			if(i%2 !=0 && a[i] <0)
			{
				int j = i+1;
				for(j=i+1; j <a.length; j++)
				{
					if(a[j] > 0)
						break;
				}
				if(j == a.length)
					return;
				
				else
				{
					int pos = a[j];
					for(int k = j; k >i; k--)
						a[k] = a[k-1];
					a[i] = pos;
				}
			}
			i++;
		}
	}
	
}
