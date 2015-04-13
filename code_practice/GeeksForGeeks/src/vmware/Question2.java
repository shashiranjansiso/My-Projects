package vmware;

public class Question2 {
	public static void main(String[] args) {
		int a[] = {5,9,14};
		System.out.println(isPossible(a, 18, a.length -1));
		//int g[] = {9000, 100,10,1};
		//int s[] = {1000, 900, 90};
		//System.out.println(maximize_loot(g, s));
		
		//ystem.out.println(DateOfWeekday(11111, 1));
		//System.out.println(DateOfWeekday(11111, 2));
		//System.out.println(DateOfWeekday(11111, 3));
	}
	
	static int DateOfWeekday(int date, int weekday) {
		int day =date;
		if(weekday == 0)
			return date;
		int d = weekday/7;
		switch(weekday%7)
		{
		case 0:
			if(weekday < 0)
				day = date -2  + (d + 1)*7;
			else
				day = date + 5 + (d - 1)*7;
			break;
		case 1:
			day = date + 6 +  d*7;
			break;
		case 2:
			day = date + 7 + d*7;
			break;
		case 3:
			day = date + 1 + d*7;
			break;
		case 4:
			day = date + 2 + d*7;
			break;
		case 5:
			day = date + 3 + d*7;
			break;
		case 6:
			day = date + 4 + d*7;
			break;
		/*case 7:
			day = date + 5 + d*7;
			break;*/
		case -1:
			day = date -1 + d*7;
			break;
		case -2:
			day = date -7 + d*7;
			break;
		case -3:
			day = date -6 + d*7;
			break;
		case -4:
			day = date -5 + d*7;
			break;
		case -5:
			day = date -4 + d*7;
			break;
		case -6:
			day = date -3 + d*7;
			break;
		case -7:
			day = date -2 + d*7;;
			break;
		}
		return day;

    }
	public static boolean isPossible(int a[], int n, int i)
	{
		if(a.length == 0)
			return false;
		if(i < 0)
			return false;
		if(n == 0)
			return true;
		if(n < 0)
			return false;
		else 
			return isPossible(a, n-a[i],i-1) || isPossible(a, n,i-1) || isPossible(a, n-a[i],i);
	}
	
	static int maximize_loot(int[] gold, int[] silver) {
		
		int w[] = new int[gold.length + silver.length];
		int p[] = new int[gold.length + silver.length];
		for(int i = 0; i < gold.length; i++)
		{
			w[i] = gold[i];
			p[i] = 10*w[i];
		}
		int j = 0;
		for(int i = gold.length; i < w.length; i++)
		{
			w[i] = silver[j++];
			p[i] = w[i];
		}
		int benefit = KnapSack(w, p, 10000, w.length);
		return benefit;
    }
	public static int KnapSack(int w[], int b[], int M, int n)
	{
		int B[][] = new int[n+1][M+1];
		for(int r = 0; r < n+1;r++)
		{
			B[r][0] = 0;
		}
		for(int c = 0; c < M+1;c++)
		{
			B[0][c] = 0;
		}
		for(int r = 1; r < n+1; r++)
		{
			for(int c = 1 ; c<M+1; c++)
			{
				if(w[r-1] > c)
				{
					B[r][c] = B[r-1][c];
				}
				else
				{
					try {
						B[r][c] = Math.max(B[r-1][c], b[r-1] + B[r-1][c-w[r-1]]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return B[n][M];
	}
	
}
