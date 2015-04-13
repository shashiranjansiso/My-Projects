package com.careercup.facebookinterviewquestions;

public class CountAllPossiblePathsInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(numPaths(0, 0, 2, 2));
		System.out.println(numPathMemoization(2, 2));
	}
	
	public static int numPaths(int x, int y,int M, int N)
	{
		if(x == M-1 && y == N-1)
			return 1;
		if(x>= M || y >= N)
			return 0;
		return numPaths(x+1, y, M, N) + numPaths(x, y+1, M, N);
	}

	public static int numPathMemoization(int M, int N)
	{
		int a[][] = new int[M][N];
		a[0][0] = 1;
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(i == 0 && j == 0)
					a[i][j] = 1;
				else if(i == 0)
					a[i][j] = a[i][j-1];
				else if(j == 0)
					a[i][j] = a[i-1][j];
				else
					a[i][j] = a[i-1][j] + a[i][j-1];
			}
		}
		return a[M-1][N-1];
	}
	
}
