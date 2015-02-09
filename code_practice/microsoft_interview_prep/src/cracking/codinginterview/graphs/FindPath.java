package cracking.codinginterview.graphs;

public class FindPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a[][] = {{0,1,0,0},
		             {0,0,1,1},
		             {0,0,0,0},
		             {0,0,0,0}};*/
		int a[][] = {{0,1,2,0},
	             {0,0,3,0},
	             {0,0,0,5},
	             {0,0,0,0}};
		boolean[][] visited = new boolean[4][4];
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				visited[i][j] = false;
			}
		}
		
		shortestPath(a, visited, 4, 0, 2, 0);
		System.out.println("mint path is " + min);
		/*boolean flag = isPath(a, visited, 4, 1, 0);
		if(flag)
			System.out.println("path is present");
		else
			System.out.println("path is not present");*/
	}
	
	public class Node
	{
		int value;
		boolean visited;
	}
	
	public static boolean isPath(int[][] graph,boolean[][] visited, int size, int src, int dst)
	{
		for(int j = 0; j < size; j++)
		{
			if(graph[src][j] == 1 && j == dst)
				return true;
			if(visited[src][j] == false && graph[src][j] == 1)
			{
				visited[src][j] = true;
				boolean flag = isPath(graph, visited, size, j, dst);
				if(flag)
					return flag;
				else
					continue;
			}
		}
		return false;
	}
	
	public static int min = 2000;

	public static void shortestPath(int[][] graph, boolean[][] visited, int size, int src, int dst, int pathlen)
	{
		for(int j = 0; j < size; j++)
		{
			if(graph[src][j] > 0 && j == dst)
			{
				pathlen +=graph[src][j];
				if(min > pathlen)
					min = pathlen;
				visited[src][j] = true;
			}
			if(graph[src][j]> 0 && !visited[src][j])
			{
				pathlen +=graph[src][j];
				visited[src][j] = true;
				shortestPath(graph, visited, size, j, dst, pathlen);
			}
		}
	}
}
