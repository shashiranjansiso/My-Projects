package com.careercup.facebookinterviewquestions;

/*
 * 
 * http://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
 * 
 */
public class SolveMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][] = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O'}
       };
		solve(mat, 5, 4);
	}
	
	public static void floodFill(char m[][], int M, int N, int x, int y,char a, char b)
	{
		if(x < 0 || y < 0 || x > M-1 || y > N-1 || m[x][y] != a)
			return;
		if(m[x][y] == a)
		{
			m[x][y] = b;
			floodFill(m, M, N, x+1, y, a, b);
			floodFill(m, M, N, x-1, y, a, b);
			floodFill(m, M, N, x, y+1, a, b);
			floodFill(m, M, N, x, y-1, a, b);
		}
	}
	
	public static void solve(char m[][], int M, int N)
	{
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(m[i][j] == 'O')
					m[i][j] = '-';
			}
		}
		for(int i = 0; i < M; i++)
		{
			//first column
			if(m[i][0] == '-')
				floodFill(m, M, N, i, 0, '-', 'O');
			//last column
			if(m[i][N-1] == '-')
				floodFill(m, M, N, i, N-1, '-', 'O');
		}
		for(int i = 0; i < N; i++)
		{
			//first row
			if(m[0][i] == '-')
				floodFill(m, M, N, 0, i, '-', 'O');
			//last row
			if(m[M-1][i] == '-')
				floodFill(m, M, N, M-1, i, '-', 'O');
		}
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(m[i][j] == '-')
					m[i][j] = 'X';
			}
		}
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.print	(m[i][j] + "   ");
			}
			System.out.println();
		}
	}

}
