//http://www.careercup.com/question?id=5639916528599040
public class MatrixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{-1, 0, -1},
				     {-1, -1, -1},
				     {-1, -1, -1}
		};
		int[][] b = findMin(a, 3, 3);
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}
	}
	
	public static int[][] findMin(int[][] a, int m, int n)
	{
		for(int i = 0; i< m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(a[i][j] == 0)
					updateMinDistance(a, m, n, i, j, 0);
			}
		}
		return a;
	}
	
	public static void updateMinDistance(int[][] a,int m, int n, int i, int j, int dist)
	{
		a[i][j] = dist;
		if(i - 1 >= 0)
		{
			a[i-1][j] = Math.min(a[i-1][j], dist + 1);
			updateMinDistance(a, m, n, i -1 , j, dist + 1);
		}
		if(i + 1 < m)
		{
			a[i+1][j] = Math.min(a[i+1][j], dist + 1);
			updateMinDistance(a, m, n, i + 1 , j, dist + 1);
		}
		if(j - 1 >= 0)
		{
			a[i][j-1] = Math.min(a[i][j-1], dist + 1);
			updateMinDistance(a, m, n, i , j - 1, dist + 1);
		}
		if(j + 1 < n)
		{
			a[i][j+1] = Math.min(a[i][j+1], dist + 1);
			updateMinDistance(a, m, n, i , j + 1, dist + 1);
		}
		
	}

}
