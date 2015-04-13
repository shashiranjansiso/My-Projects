package com.careercup.facebookinterviewquestions;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3};
		//System.out.println(CC(a, a.length -1, 10));
		CCMemoization(a, 4);
	}
	
	public static int CC(int a[], int i, int N)
	{
		if(N < 0)
			return 0;
		if(N==0)
			return 1;
		if(i < 0)
			return 0;
		else 
			return CC(a, i, N-a[i]) + CC(a, i-1, N);
	}
	
	public static void CCMemoization(int a[], int N)
	{
		int m[][] = new int[a.length + 1][N+1];
		for(int i = 0; i < a.length + 1; i++)
		{
			for(int j = 0; j < N+1; j++)
			{
				if(j == 0)
					m[i][j] = 1;
				else if(i == 0 && j!=0)
					m[i][j] = 0;
				else
				{
					if(j - a[i-1] < 0)
						m[i][j] = m[i-1][j];
					else
						m[i][j] = m[i][j-a[i-1]] + m[i-1][j];
				}
			}
		}
		for(int i = 0; i < a.length + 1; i++)
		{
			for(int j = 0; j < N+1; j++)
			{
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
		
	}

}
