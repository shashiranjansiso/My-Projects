package com.careercup.facebookinterviewquestions;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
               };
		fill(screen, 8, 8, 4, 4, 3);
	}
	
	public static void fill(int m[][], int M, int N, int x, int y, int nc)
	{
		flood(m, M, N, x, y, nc, m[x][y]);
		for(int i = 0 ; i < M; i++)
		{
			for(int j = 0; j <N; j++)
			{
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void flood(int m[][], int M, int N, int x, int y, int nc, int oc)
	{
		if(x<0 || y < 0 || x >= M || y >= N || m[x][y] != oc)
			return;
		m[x][y] = nc;
		flood(m, M, N, x+1, y, nc, oc);
		flood(m, M, N, x-1, y, nc, oc);
		flood(m, M, N, x, y-1, nc, oc);
		flood(m, M, N, x, y+1, nc, oc);
	}

}
