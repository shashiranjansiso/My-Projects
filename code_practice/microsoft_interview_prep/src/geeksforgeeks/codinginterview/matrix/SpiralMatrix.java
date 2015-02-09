package geeksforgeeks.codinginterview.matrix;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = spiralMatrix(4, 4, 0);
		
		for(int i = 0;i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}
	}

	public static int[][] spiralMatrix(int m, int n, int start)
	{
		int[][] a = new int[m][n];
		int i, r = 0, c = 0;
		while(r<m && c<n)
		{
			for(i = c; i<n; i++) //first row
				a[r][i] = start++;
			r++;
 			for(i = r ; i < m ; i++)  //last column
				a[i][n-1] = start++;
			n--;
			if(c<n)
			{
				for(i = n -1; i>=c; i--)  //last row
					a[m-1][i] = start++;
				m--;
			}
			if(r<m)
			{
				for(i = m - 1 ; i >= r; i--)  //first column
					a[i][c] = start++;
				c++;
			}
		}
		
		return a;
	}
	
}
