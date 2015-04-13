package com.careercup.facebookinterviewquestions;

public class NQueenProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = { {0, 0, 0, 0},
					        {0, 0, 0, 0},
					        {0, 0, 0, 0},
					        {0, 0, 0, 0}
					    };
		solveNQueen(board, 4, 4);
	}

	public static void solveNQueen(int b[][], int M, int N)  
	{
	    if(solveNQueenUtil(b, 0, M, N))
	    {
	        System.out.println("solution is possible ");
	        for(int i = 0; i < N; i++)
	        {
	            for(int j = 0; j < N; j++)
	            {
	                System.out.print(b[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    else
	        System.out.println("solution is not possible ");
	}  


	public static boolean isSafe(int b[][], int r, int c, int M, int N)
	{
	    //check for row backward
	    for(int i = 0; i < c; i++)
	    {
	        if(b[r][i] == 1)
	            return false;
	    }
	    
	    //check for column upward
	     for(int i = 0; i < r; i++)
	    {
	        if(b[i][c] == 1)
	            return false;
	    }
	    //check for diagonal
	    int i = r-1; int j = c-1;
	    while(i >=0 && j >= 0)
	    {
	        if(b[i][j] == 1)
	            return false;
            i--;
            j--;
	    }
	    return true;
	}

	public static boolean solveNQueenUtil(int b[][],int r, int M,int N)
	{
	    if(r == M)
	        return true;
	    for(int i = 0; i < N; i++)
	    {
	        if(isSafe(b, r, i, M, N))
	        {
	            b[r][i] = 1;
	            if(solveNQueenUtil(b, r+1, M, N))
	                return true;
	            b[r][i] = 0;   
	        }
	    }    
	    return false;
	}
	
}
