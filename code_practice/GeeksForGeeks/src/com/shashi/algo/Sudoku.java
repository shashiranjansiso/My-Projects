package com.shashi.algo;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = {
					};
	}
	
	public static boolean usedInBox(int M[][], int startR, int startC, int num)
	{
		for(int i= 0; i <2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				if(M[i+startR][j+startC] == num)
					return false;
			}
		}
		return true;
	}
	
	public static int r, c;
	public static boolean findUnsassignedPos(int M[][])
	{
		for(int i = 0; i < M[0].length; i++)
		{
			for(int j = 0; j < M[0].length; j++)
			{
				if(M[i][j] ==0)
				{
					r = i;
					c = j;
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int M[][], int r, int c, int num)
	{
		//check for column
		for(int i = 0; i < M[0].length; i++)
		{
			if(M[r][i] == num)
				return false;
		}
		//check for that row
		for(int i = 0; i < M[0].length; i++)
		{
			if(M[i][c] == num)
				return false;
		}
		if(usedInBox(M, r - r%2, c- c%2, num))
			return true;
		return true;
	}
	
	public static boolean solveSudoku(int M[][])
	{
		if(!findUnsassignedPos(M))
			return true;
		for(int i = 1; i < 10; i++)
		{
			if(isSafe(M, r, c, i))
			{
				M[r][c] = i;
				if(solveSudoku(M))
					return true;
				M[r][r] = 0;
			}
		}
		return false;
	}

}
