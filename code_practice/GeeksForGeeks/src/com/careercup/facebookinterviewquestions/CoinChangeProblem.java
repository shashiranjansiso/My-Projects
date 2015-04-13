package com.careercup.facebookinterviewquestions;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2, 5, 3, 6};
		//System.out.println(CC(a, a.length -1, 4, ""));
		System.out.println(CCMemoization(a, 10));
	}
	
	public static int CC(int a[], int i, int N, String path)
	{
		if(N == 0)
		{
			System.out.println(path);
			return 1;
		}
		if(N < 0 || i < 0)
			return 0;
		return CC(a, i, N-a[i], path + a[i] + "  ") + CC(a, i-1, N, path);	
	}

	public static int CCMemoization(int a[], int N)
	{
		int m[][] = new int[a.length + 1][N + 1];
		for(int i = 0; i < a.length + 1; i++)
		{
			for(int j = 0; j < N+1; j++)
			{
				if(j == 0)
					m[i][j] = 1;
				else if(i == 0 || j == 0)
					m[i][j] = 0;
				else
				{
					if(a[i-1] > j)
						m[i][j] = m[i-1][j];
					else
						m[i][j] = m[i][j - a[i-1]] + m[i-1][j];
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
		return m[a.length][N];
	}
	
}
