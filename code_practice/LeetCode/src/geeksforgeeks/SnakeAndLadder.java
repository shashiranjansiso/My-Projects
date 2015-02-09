package geeksforgeeks;


public class SnakeAndLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 30;
	    int moves[] = new int[N];
	    boolean visited[] = new boolean[N];
	    for (int i = 0; i<N; i++)
	    {
	        moves[i] = -1;
	        visited[i] = false;
	    }
	 
	    // Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
	   
	    System.out.println(getMinDiceThrows(moves, N, visited));
	}

	public static int getMinDiceThrows(int[] moves, int n, boolean[] visited)
	{
		visited[0] = true;
		return move(moves, n, 0, 0, visited);
	}
	
	public static int move(int[] moves, int n, int pos, int nthrows, boolean[] visited)
	{
	/*	if(pos == 2)
			System.out.println(pos);
		if(pos == 21)
			System.out.println(pos);
		if(pos == 27)
			System.out.println(pos);
		if(pos == 29)
			System.out.println(pos);
		System.out.println();*/
		if(pos == n -1)
		{
			System.out.println("throws: " + nthrows);
			return nthrows;
		}if(pos > n -1)
			return Integer.MAX_VALUE;
		//visited[pos] = true;
		if(moves[pos] != -1)
			pos = moves[pos];
		//visited[pos] = true;
		//List<Integer> list = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=6; i++)
		{
			if(pos + i <= n -1){
				if(!visited[pos + i]){
					visited[pos + i] = true;
					//list.add(move(moves, n, pos + i + 1, nthrows + 1, visited));
					int dist = move(moves, n, pos + i, nthrows + 1, visited);
					System.out.println("dist : " + dist);
					if(dist < min)
						min = dist;
				}
			}
		}
		return min;
	}
	
	
}
