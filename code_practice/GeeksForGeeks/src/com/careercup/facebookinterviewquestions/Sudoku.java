package com.careercup.facebookinterviewquestions;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
		                {5, 2, 0, 0, 0, 0, 0, 0, 0},
		                {0, 8, 7, 0, 0, 0, 0, 3, 1},
		                {0, 0, 3, 0, 1, 0, 0, 8, 0},
		                {9, 0, 0, 8, 6, 3, 0, 0, 5},
		                {0, 5, 0, 0, 9, 0, 6, 0, 0},
		                {1, 3, 0, 0, 0, 0, 2, 5, 0},
		                {0, 0, 0, 0, 0, 0, 0, 7, 4},
		                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		SolveSudoku(grid, 9, 9);
	}

	public static void SolveSudoku(int g[][] ,int M,int N) 
	{
	    if(solveSudokuUtil(g,M, N))
	    {
	        for(int i = 0; i < M; i++)
	        {
	            for(int j = 0; j < N; j++)
	            {
	                System.out.print(g[i][j] + "  ");
	            }
	            System.out.println();
	        }
	    }
	}                 

	public static int x; 
	public static int y;

	public static boolean getEmptyCell(int g[][],int M,int N)
	{
	    for(int i = 0; i < M; i++)
	    {
	        for(int j = 0; j < N; j++)
	        {
	            if(g[i][j] == 0)
	            {
	                x = i;
	                y = j;
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public static boolean UsedInRow(int grid[][],int M, int N, int row, int num)
	{
	    for (int col = 0; col < N; col++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	public static boolean UsedInCol(int grid[][], int M, int N, int col, int num)
	{
	    for (int row = 0; row < N; row++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	public static boolean isSafe(int g[][], int M, int N, int x, int y, int n)
	{
	       //if n is already present in that row
	       /*for(int c = 0; c < N; c++)
	       {
	           if(g[x][c] == n)
	               return false;
	       }*/
		return !UsedInRow(g, M,N,x, n) &&
		           !UsedInCol(g, M,N,y, n) &&
		           !UsedInBox(g, x - x%3 , y - y%3, n);
			//if(UsedInRow(g, M, N, x, n))
			//	return false;
	       //if n is already present in that column
			//if(UsedInCol(g, M, N, y, n))
			//	return false;
	       /*for(int r = 0; r < M; r++)
	       {
	           if(g[r][y] == n)
	               return false;
	       }*/
	       // if n is already present in that cell
	       //if(UsedInBox(g, x - x%3 , y - y%3, n))
	        //   return false;
	       //else return true
	      // return true;
	}

	public static boolean UsedInBox(int g[][], int boxStartRow, int boxStartCol, int num)
	{
	    for (int row = 0; row < 3; row++)
	        for (int col = 0; col < 3; col++)
	            if (g[row+boxStartRow][col+boxStartCol] == num)
	                return true;
	    return false;
	}
	
	public static boolean isPresentInBox(int g[][], int x, int y, int M, int N, int n)
	{
	    int i = x/3;
	    int j = y/3;
	    int startX = i*3;
	    int startY = j*3;
	    for(i = startX; i < startX +3; i++)
	    {
	        for(j = startY; j < startY + 3; j++)
	        {
	            if(g[i][j] == n)
	                  return true;
	        }
	    }
	    return false;
	}

	public static boolean solveSudokuUtil(int g[][], int M,int N)
	{
	    if(!getEmptyCell(g, M, N))
	        return true;
	    for(int i = 1; i < 10; i++)
	    {
	        if(isSafe(g, M, N,x, y, i))
	        {
	            g[x][y] = i;
	            if(solveSudokuUtil(g, M, N))
	                return true;
	            g[x][y] = 0;
	        }
	    }
	    return false;
	}
	
}
