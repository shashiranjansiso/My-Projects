package com.careercup.facebookinterviewquestions;

public class GraphColoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = {{0, 1, 1, 1},
		        {1, 0, 1, 0},
		        {1, 1, 0, 1},
		        {1, 0, 1, 0},
		    };
		graphColoring (graph, 3, 4,4);
	}

	public static void graphColoring(int g[][], int m, int M, int N)
	{
	    int c[] = new int[M];
	    
	    for(int i = 0; i < M; i++)
	    {
	        c[i] = -1;
	    }
	    
	    if(gcutil(g, m, c, 0, M, N))
	    {
	        System.out.println("coloring is possible");
	        for(int i = 0 ; i < M; i++)
	            System.out.println("vertex " + i + "   color "+ c[i] );
	    }
	    else
	        System.out.println("coloring is not possible");
	}    

	public static boolean isSafe(int g[][], int c[], int color, int r, int M, int N)
	{
	    for(int i = 0; i < N; i++)
	    {
	        if(g[r][i] == 1 && c[i] == color)
	            return false;
	    }
	    return true;
	}

	public static boolean gcutil(int g[][], int m, int c[], int r, int M,int N)
	{
	    if(r == M)
	        return true;
	    for(int i = 1; i <= m; i++)
	    {
	        if(isSafe(g, c, i, r, M, N))
	        {
	            c[r] = i;
	            if(gcutil(g, m, c, r+1, M, N))
	                return true;
	            c[r] = -1;
	        }
	    } 
	    return false;
	}
	
}
