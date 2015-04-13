package com.shashi.algo;

public class MaximumLengthPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = new String("PAYBZBA");    // ABXBA
		char a[] = X.toCharArray();
		System.out.println(LP(a, 0, a.length -1));
	}
	
	public static int LP(char a[], int i, int j)
	{
		if(i==j)		//single lenght palindrome
			return 1;
		else if(j==i+1 && a[i] != a[j])
			return 1;
		else if(j==i+1 && a[i] == a[j])
			return 2;
		else if(a[i] == a[j])
			return 2 + LP(a, i+1, j-1);
		else 
			return Math.max(LP(a, i, j-1), LP(a, i+1, j));
	}

}
