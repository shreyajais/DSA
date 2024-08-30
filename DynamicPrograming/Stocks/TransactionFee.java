package DSA.DynamicPrograming.Stocks;

public class TransactionFee {

    // same as cool down just add fee when buy = 1 which mean sell. which mean one transaction
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int i = n-1; i>=0; i--){
            dp[i][0] = Math.max(0 + dp[i+1][0], -prices[i] + dp[i+1][1]);
            dp[i][1] = Math.max(0 + dp[i+1][1], prices[i] + dp[i+1][0]-fee);
        }
        return dp[0][0];
    }


}
