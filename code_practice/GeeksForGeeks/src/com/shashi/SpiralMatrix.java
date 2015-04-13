package com.shashi;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 3; 
		int C = 6;
		int a[][] = { {1,  2,  3,  4,  5,  6},
						{7,  8,  9,  10, 11, 12},
						{13, 14, 15, 16, 17, 18}
		    };
		printSprial(a, R, C);
	}
	
	public static void printSprial(int a[][], int M, int N)
	{
		int r1,r2,c1,c2;
		r1 = 0;
		r2 = M-1;
		c1 = 0;
		c2 = N-1;
		while(r1 <= r2 && c1 <= c2)
		{
			//first row
			for(int c = c1; c<=c2;c++)
			{
				System.out.print(a[r1][c] + "  ");
			}
			r1++;
			//last column
			if(r1 < r2)
			{
				for(int r = r1; r <= r2; r++)
					System.out.print(a[r][c2] + "  ");
				c2--;
			}
			//last row
			if(c2 > c1 && r2>r1)
			{
				for(int c = c2; c >= c1; c--)
					System.out.print(a[r2][c] + "  ");
				r2--;
			}
			//first column
			if(r2>r1)
			{
				for(int r = r2; r >= r1; r--)
					System.out.print(a[r][c1] + "  ");
				c1++;
			}
		}
	}

}
