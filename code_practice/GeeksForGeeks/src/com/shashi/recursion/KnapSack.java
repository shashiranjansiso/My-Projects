package com.shashi.recursion;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w[] = {2,3,4,5};
		//int b[] = {3,4,5,6};
		int b[] = {3,7,2,9};
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    System.out.println(maxProfit(w, b, 5, b.length -1));
	}

	public static int maxProfit(int w[], int b[], int maxW, int i)
	{
		if(i < 0)
			return 0;
		if(w[i] > maxW)
			return maxProfit(w, b, maxW, i-1);   
		if(maxW < 0)
			return 0;
		return Math.max(maxProfit(w, b, maxW - w[i], i -1) + b[i], maxProfit(w, b, maxW, i-1));
	}
	
}
