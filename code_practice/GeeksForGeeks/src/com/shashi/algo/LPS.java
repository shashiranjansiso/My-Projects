package com.shashi.algo;

public class LPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "forgeeksskeegfor";
		System.out.println("fir String : " + s);
		System.out.print("longst palindrome substring lenth is ");
		System.out.println(LPS1(s.toCharArray(), 0, s.length() -1, 0));
	}

	public static int LPS1(char a[], int i, int j, int maxlen)
	{
	     if(i == j)
	         return maxlen + 1;
	     if (j == i+1 && a[i] == a[j]) 
	         return maxlen+2;
	     if (j == i+1 && a[i] != a[j]) 
	         return 1;
	     if(a[i] == a[j])
	         return LPS1(a, i+1, j-1, maxlen+2);
	     else
	         return Math.max(LPS1(a, i+1, j, 0), LPS1(a, i, j-1, 0));             
	}

	
}
