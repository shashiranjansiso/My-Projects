package backtracking;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int a[] = new int[2*N];
		
		for(int i =0; i<2*N;i++)
			a[i] = 0;
		boolean result = fillArray(a, N, N);
		if(result == false)
		{
			System.out.println("No soltion possible");
			return;
		}
		for(int i =0; i<2*N;i++)
			System.out.print(a[i] + " ");
	}
	
	public static boolean fillArray(int[] a, int n, int N)
	{
		if(n <= 0)
			return true;
		for(int i = 0; i< 2*N; i++)
		{
			if(i + n + 1 < 2*N)
			{
				if(a[i] == 0 && a[i + n + 1] == 0) //safe
				{
					a[i] = n;
					a[i+n+ 1] = n;
					if(fillArray(a, n -1, N) == true)
						return true;
					a[i] = 0;
					a[i+n+1] = 0;
				}
			}
		}
		return false;
	}

}
