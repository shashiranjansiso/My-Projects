package com.careercup.facebookinterviewquestions;

public class SolveRatInMazeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][]  =  { {1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		    };
		solveMaze(maze, 4, 4);
	}
	public static int moveX[] = {0,1};
	public static int moveY[] = {1,0};    

	public static void solveMaze(int maze[][], int M, int N)
	{
		int sol[][] = new int[M][N];
	    for(int i = 0; i < M; i++)
	    {
	        for(int j = 0; j < N; j++)
	        {
	            sol[i][j] = 0;
	        }
	    }
	    sol[0][0] = 1;
	     if(solveMazeUtil(maze, 0,0, M, N, sol))
	     {
	         System.out.println("solution is possible");
				for(int i = 0; i < M; i++)
				{
				    for(int j = 0; j < N; j++)
				    {
				        System.out.print(sol[i][j]);
				    }
				    System.out.println();
				}
	     }   
	     else
	         System.out.println("solution is not possible");
	}    

	public static boolean isSafe(int m[][], int x, int y, int M, int N)
	{
	    if(x<0 || y < 0 || x >= M || y >= N || m[x][y] == 0)
	        return false;
	    return true;
	}

	public static boolean solveMazeUtil(int m[][], int x, int y, int M, int N, int sol[][])
	{
	    if(x == M-1 && y == N-1)
	    {
	        return true;
	    }        
	    if(!isSafe(m, x, y, M, N))
	        return false;
	    for(int i = 0; i < 2; i++)
	    {
	        int nX = x + moveX[i];
	        int nY = y + moveY[i];
	        sol[nX][nY] = 1;
	        if(solveMazeUtil(m, nX, nY, M, N, sol))
	            return true;
	        sol[nX][nY] = 0;   
	    } 
	    return false;   
	        
	}
}
