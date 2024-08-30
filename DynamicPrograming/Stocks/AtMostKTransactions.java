package DSA.DynamicPrograming.Stocks;

public class AtMostKTransactions {
    // at most K transactions.
    //  int[][][] dp = new int[n][2][k + 1]; // fill 3d array with -1
    // func(index(0), 0(buy/sell), k, k(allowedTransactionSoFar) arr, dp)
    // so base case when ind == 0 or allowedTransactionSoFar == 0
    // 3 loop: (n-1 to 0) (0 to 1) (1 to K)
    // dp[ind][buy][cap] = profit;
// take and notTake for both buy == 0 and buy == 1
    public int maxProfitDp(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k];
        for(int tr = 0; tr<=k; tr++){
            dp[n][0][tr] = 0; dp[n][1][tr] = 0;
        }
        for(int i = 0; i<=n; i++){
            dp[i][0][0] = 0; dp[i][1][0] = 0;
        }
        for(int i = n-1; i>=0; i--){
            for(int tr =1; tr<=k; tr++){
                dp[i][0][tr] = Math.max(0 + dp[i+1][0][tr], -prices[i] + dp[i+1][1][tr]);
                dp[i][1][tr] = Math.max(0 + dp[i+1][1][tr], prices[i] + dp[i+1][0][tr-1]);
            }
        }
        return dp[0][0][k];
    }
}


