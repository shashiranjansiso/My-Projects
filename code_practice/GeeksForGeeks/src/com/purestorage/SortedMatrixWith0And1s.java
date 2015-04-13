package com.purestorage;

public class SortedMatrixWith0And1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { {0, 1, 1, 1},
				        {1, 1, 1, 1},
				        {0, 0, 0, 1},
				        {1, 1, 1, 1}
					};
		System.out.println(getIndex(mat));
	}
	
	public static int getIndex(int a[][])
	{
		int index = -1;
		int row = -1;
		for(int i = 0; i < a.length; i++)
		{
			if(index < 0)
			{
				//first row
				index = bsearch(a[i], 0, a[i].length -1);
				row = 0;
			}
			else
			{
				if(a[i][index] == 1)
				{
					int in = bsearch(a[i], 0, index -1);
					if(in!= -1)
						index = in;
					row = i;
				}
			}
				
		}
		return row;
	}
	
	public static int bsearch(int a[], int l, int h)
	{
		if(l > h)
			return -1;
		if(a[l] == 1)
			return l;
		int m = (l+h)/2;
		if(a[m] == 0 && a[m+1] == 1)
			return m+1;
		if(a[m] == 0)
			return bsearch(a, m+1, h);
		else
			return bsearch(a, l, m-1);
	}

}
