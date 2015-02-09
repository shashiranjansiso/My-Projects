package cracking.codinginterview.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{0,1,0,0},
	             {0,0,1,1},
	             {0,0,0,0},
	             {0,0,0,0}};
		bfs(a, 0, 4);
	}
	
	public static void bfs(int[][] a, int src, int size)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		int newsrc;
		while(!queue.isEmpty())
		{
			newsrc = queue.remove();
			System.out.println(newsrc + "   ");
			for(int i=0; i< size; i++)
			{
				if(a[newsrc][i] == 1)
					queue.add(i);
			}
		}
	}
	

}
