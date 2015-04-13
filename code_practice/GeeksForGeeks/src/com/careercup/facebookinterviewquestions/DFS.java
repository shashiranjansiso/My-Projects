package com.careercup.facebookinterviewquestions;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int adj[][] = {
				{0,1,1,0},
				{0,0,1,0},
				{1,0,0,1},
				{0,0,0,1}
		};
		boolean v[] = new boolean[adj[0].length];
		System.out.println("2");
		v[2] = true;
		DFS1(adj, 2, v);
	}
	
	public static void DFS1(int adj[][], int i, boolean v[])
	{
		for(int j = 0; j < v.length; j++)
		{
			if(adj[i][j] == 1 && !v[j])
			{
				System.out.println(j);
				v[j] = true;
				DFS1(adj, j, v);
			}
		}
	}

}
