package com.careercup.facebookinterviewquestions;

public class FindMissingInAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,4,6,8,10,12,14};
		int d = (a[a.length-1] - a[0])/a.length;
		System.out.println(search(a, 0, a.length-1, d));
	}	
	
	public static int search(int a[], int l, int h, int d)
	{
		int m = (l+h)/2;
		int req = a[0] + m*d;
		if(a[m] > req)
		{
			if(m -1 >= 0 && a[m] - a[m-1] > d)
				return a[m] -d;
			else
				return search(a, l, m-1, d);
		}
		else
		{
			if(m+1 <= h && a[m+1] - a[m] > d)
				return a[m] + d;
			else
				return search(a, m+1, h, d);
		}
	}

}
