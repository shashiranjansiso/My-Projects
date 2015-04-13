package com.careercup.facebookinterviewquestions;

public class SearchInPivotedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 5,1,2,3,4};
		System.out.println(search(a, 2));
	}


	public static int search(int a[], int n)
	{
	    if(a.length == 0)
	        return -1;
	    int pivot = findPivot(a, 0, a.length -1);
	    if(pivot == -1)
	    {
	        // already sorted
	    }
	    else if(a[pivot] == n)
	        return pivot;
	    else if(n < a[0])
	    {
	        //search in right half
	        return binarySearch(a, pivot +1, a.length-1, n);
	    }
	    else
	    {
	        //search in left half
	        return binarySearch(a, 0, pivot-1, n);
	    }
	    return -1;
	}

	public static int binarySearch(int a[], int l, int h, int n)
	{
	    if(l > h)
	        return -1;
	    int m = (l + h)/2;
	    if(a[m] == n)
	        return m;
	    if(n > a[m])
	    	return binarySearch(a, m +1, h, n);
	    else
	        return binarySearch(a, l, m-1, n);
	}

	public static int findPivot(int a[], int l, int h)
	{
	    if(l > h)
	        return -1;
	    int m = (l +h)/2;
	    if(a[m] > a[m+1])
	        return m;
	    if(a[l] > a[h])
	        return findPivot(a, l, m -1);
	    else
	        return findPivot(a, m+1, h);        
	}
}