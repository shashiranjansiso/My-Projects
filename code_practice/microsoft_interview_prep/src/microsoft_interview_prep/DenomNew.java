package microsoft_interview_prep;

import java.util.Arrays;

public class DenomNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = {1,5,10,25};
		int denom = getDenom(110, d);
		System.out.println(denom);
	}

	public static int getDenom(int am, int[] d)
	{
		if(am <= 0)
			return 0;
		Arrays.sort(d);
		int dp[] = new int[am + 1];
		dp[0] = 0;
		for(int i = 1; i<= am ; ++i)
		{
			int min = Integer.MAX_VALUE;
			for(int j = 0; i<d.length && i >= d[j]; ++j)
			{
				if(dp[i-d[j]] != Integer.MAX_VALUE && min > 1+ dp[i - d[j]])
				{
					min = 1 + dp[i - d[j]];
				}
			}
			dp[i] = min;
		}
		 return (dp[am] == Integer.MAX_VALUE) ? 0 : dp[am];
	}
	
}
