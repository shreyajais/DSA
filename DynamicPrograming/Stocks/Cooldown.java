package DSA.DynamicPrograming.Stocks;

public class Cooldown {

    // recursion: func(index, buy(boolean), len, arr, dp[n][2]) 2: 0(you can buy) 1 (you cannot buy, you can sell)
    // return func(0, 0, len, arr , dp) as we can only buy at 1st day


    // tabulation:
    // ques: int dp[][] = new int[n + 2][2]; Why ???
    // we start filling by last day.  towards 1st day. this dp cell defines is the profit 0: buy and 1: sell and index is the day.
    // // WE ARE BUYING ONE DAY BEFORE SELLING
    // WE CANNOT SELL IF WE HAVE BOUGHT ON DAY BEFORE , SO GAP SHOULD BE ONE DAY
    // return dp[0][0]

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n+1][0] = dp[n+1][1] = 0;
        dp[n][0] = dp[n][1] = 0;
        for(int i = n-1; i>=0; i--){
            dp[i][0] = Math.max(0 + dp[i+1][0], -prices[i] + dp[i+1][1]);
            dp[i][1] = Math.max(0 + dp[i+1][1], prices[i] + dp[i+2][0]);
        }
        return dp[0][0];
    }
}
