package com.shashi;

/*
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * 
 */
public class CountMatrixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(3, 3, 0, 0));
	}
	public static int dx[] = {0, 1};
	public static int dy[] = {1, 0};
	
	public static int count(int m,int n, int x, int y)
	{
		if(x == m-1 && y == n-1)
			return 1;
		if(x>m || y > n)
			return 0;
		return count(m, n, x + dx[0], y + dy[0])
				+ count(m, n, x + dx[1], y + dy[1]);
	}
	
}
