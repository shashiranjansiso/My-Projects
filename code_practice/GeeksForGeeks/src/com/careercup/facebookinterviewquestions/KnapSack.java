package com.careercup.facebookinterviewquestions;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
		/*int val[] = {3, 4, 5, 6};
	    int wt[] = {2,3,4,5};
	    int  W = 5;*/
	    System.out.println(kp(val, wt, val.length -1, W));
	    System.out.println(KSmemoization(val, wt, W));
	}
	
	public static int kp(int v[], int wt[], int i, int w)
	{
		if(i<0)
			return 0;
		if(wt[i] > w)
			return kp(v, wt, i-1, w);
		else
			return Math.max(v[i] + kp(v, wt, i-1, w-wt[i]), kp(v, wt, i-1, w));
		
	}
	
	public static int KSmemoization(int v[], int wt[], int W)
	{
		int m[][] = new int[v.length + 1][W+1];
		for(int i = 0; i < v.length + 1; i++)
		{
			for(int w = 0; w < W+1; w++)
			{
				if(i ==0 || w == 0)
					m[i][w] = 0;
				else
				{
					if(wt[i-1] > w)
						m[i][w] = m[i-1][w];
					else
						m[i][w] = Math.max(m[i-1][w-wt[i-1]] + v[i-1], m[i-1][w]);
				}
			}
		}
		/*for(int i = 0; i < v.length + 1; i++)
		{
			for(int w = 0; w < W+1; w++)
			{
				System.out.print(m[i][w]);
			}
			System.out.println();
		}*/
		return m[v.length][W];
	}
	
}

