package Bloomberg;

import cracking.codinginterview.arraysandstrings.Problem1;

public class SpiralMatrix {

	public static void main(String[] args) {
		Problem1 p = new Problem1();
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4},
		        {5,6,7,8},
		        {9,10,11,12},
		        {13,14,15,16}
		    };
		 printSpiral(a, 4, 4);
		    //spiralPrint(4, 4, a);
	}

	public static void spiralPrint(int m, int n, int a[][])
	{
	    int i, k = 0, l = 0;
	 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	            System.out.println( a[k][i]);
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	            System.out.println( a[i][n-1]);
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	                System.out.println( a[m-1][i]);
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	                System.out.println( a[i][l]);
	            }
	            l++;    
	        }        
	    }
	}
	
	
	public static void printSpiral(int[][] a, int m, int n)
	{
		int r =0,c = 0;
		int k1 = (m - 1);
		int k2 = (n - 1);
		while(r < n/2 || c < n/2)
		{
			int i,j,k,l;
			for(i = c; i< k1; i++)
				System.out.println(a[r][i] + " ");
			k1--;r++;
			for(j = r; j< k2; j++)
				System.out.println(a[j][i] + " ");
			k2--;
			for(k = i -1; k>=c ; k++)
				System.out.println(a[j][k] + " ");
			c++;
			for(l = j-1; i>=r; l++)
				System.out.println(a[l][k] + " ");
			
		}
	}
}
