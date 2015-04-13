package com.careercup.facebookinterviewquestions;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { {1, 2, 3},
                		{4, 8, 2},
                		{1, 5, 3} };
		//System.out.println(MCP(cost, 2, 2));
		System.out.println(MCPMemoization(cost, 2, 2));
	}

	public static int MCP(int m[][], int x, int y)
	{
		if(x == 0 && y == 0)
			return m[0][0];
		if(x < 0 || y < 0)
			return Integer.MAX_VALUE;
		return m[x][y] + Math.min(MCP(m, x-1, y), Math.min(MCP(m, x-1, y-1), MCP(m, x, y-1)));
	}
	
	public static int MCPMemoization(int m[][], int x, int y)
	{
		int s[][] = new int[x+2][y+2];
		for(int i = 0; i < x+2; i++)
		{
			for(int j = 0; j < y+2; j++)
			{
				if(i == 0 || j == 0)
					s[i][j] = Integer.MAX_VALUE;
				else
				{
					int min = Math.min(s[i-1][j-1], Math.min(s[i-1][j], s[i][j-1]));
					if(min == Integer.MAX_VALUE)
						min = 0;
					s[i][j] = m[i-1][j-1] + min; 
					//System.out.println(s[i][j]);
				}
			}
		}
		for(int i = 1; i < x+2; i++)
		{
			for(int j = 1; j < y+2; j++)
			{
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		return s[x+1][y+1];
	}
	
}
