package com.careercup.facebookinterviewquestions;
/*
 * 
 * http://www.careercup.com/question?id=6204973461274624
 */
public class SubsetPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = new int[4];
		//P(5, 0, 1,4, a);
			int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
			System.out.println(minHop(arr	));
	}
	
	public static void P(int N, int i1,int i2, int k, int a[])
	{
		if(i1==k)
		{
			for(int i = 0; i < k ;i++)
			{
				System.out.print(a[i] + "  ");
			}
			System.out.println();
			return;
		}
		for(int i=i2; i <= N; i++)
		{
			a[i1] = i;
			P(N, i1+1, i+1, k, a);
		}
	}
	public static int minHop(int a[])
	{
		int mh[] = new int[a.length];
		mh[0] = 0;
		for(int i = 1; i < a.length; i++)
		{
		    int min = 1000;
		    for(int j = 0; j < i; j++)
		    {
		        if(j+a[j] >= i)
		        {
		            //reachable 
		            if(mh[j] + 1 < min)
		                min = mh[j] +1;
		        }
		        mh[i] = min;
		    }
		}
		return mh[a.length-1];
	}
}
