package DSA.DynamicPrograming.Stocks;

public class AtMost2Transactions {
    // int[][][] dp = new int[n][2][3];
    // func(index(0), 0(buy/sell), 2, 2(allowedTransactionSoFar) arr, dp)
    // BC: index == 0 or allowedTransactionSoFar == 0
    // 3 loop: (n-1 to 0) (0 to 1) (1 to 2)
    public int maxProfitDp(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int k = 0; k<2; k++){
            dp[n][0][k] = 0; dp[n][1][k] = 0;
        }
        for(int i = 0; i<=n; i++){
            dp[i][0][0] = 0; dp[i][1][0] = 0;
        }
        for(int i = n-1; i>=0; i--){
            for(int k =0; k<=2; k++){
                dp[i][0][k] = Math.max(0 + dp[i+1][0][k], -prices[i] + dp[i+1][1][k]);
                dp[i][1][k] = Math.max(0 + dp[i+1][1][k], prices[i] + dp[i+1][0][k-1]);
            }
        }
        return dp[0][0][2];
    }
}
// 0, 0, 0  -----> 0, 0, 1 ---> 0, 1, 0 ---> 0, 1, 1 ---> 1, 0, 0, ---> 1, 0, 1, ----> 1, 1, 0 ----> 1, 1 ,1