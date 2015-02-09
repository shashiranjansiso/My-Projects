package microsoft_interview_prep;

import java.util.Arrays;

public class Denom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = {1,5,10,25};
		int denom = getMinCoinsForAmt(d, 110);
		System.out.println(denom);
	}

	public static int getMinCoinsForAmt(int denoms[], int amt) {
        if (amt <= 0 || denoms == null || denoms.length == 0) {
            return 0;
        }
        Arrays.sort(denoms); // Not needed if already sorted!
        int dp[] = new int[amt + 1];
        dp[0] = 0;
        for (int i = 1; i <= amt; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < denoms.length && i >= denoms[j]; ++j) {
                if (dp[i - denoms[j]] != Integer.MAX_VALUE &&
                    min > 1 + dp[i - denoms[j]]) {
                    min = 1 + dp[i - denoms[j]];
                }
            }
            dp[i] = min;
        }
        return (dp[amt] == Integer.MAX_VALUE) ? 0 : dp[amt];
    }
	
	
}
