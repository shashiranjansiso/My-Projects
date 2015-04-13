package com.careercup.facebookinterviewquestions;

public class FindInAlmostSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {10, 3, 40, 20, 50, 80, 70};
		System.out.println(bsearch(arr, 0, arr.length -1, 1));
	}
	
	public static int bsearch(int a[],int l, int h, int x)
	{
		if(l>h)
			return -1;
		int m = (l+h)/2;
		if(x == a[m])
			return m;
		if(m+1 <= h && x == a[m+1])
			return m+1;
		if(m-1 >= l && x == a[m-1])
			return m-1;
		int max = Math.max(a[m], Math.max(a[m-1], a[m+1]));
		if(x>max)
			return bsearch(a, m+2, h, x);
		else
			return bsearch(a, l, m-2, x);
	}

}
