package DSA.DynamicPrograming.Subsequence;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int len = 0;
        int[][] dp = new int[len][amount+1];
        for(int i =1; i<=len; i++){
            dp[i][0]= Integer.MAX_VALUE;
        }
        for(int j = 1; j<= amount; j++){
            if(coins[0]<=j && j%coins[0] == 0){
                dp[0][j] = j/coins[0];
            } else dp[0][j] = Integer.MAX_VALUE;
        }
        for(int i = 1; i<len;i++){
            for(int j = 1; j<=amount; j++){
                int notTaken = dp[i-1][j];
                int taken = Integer.MAX_VALUE;
                if(j>= coins[i]){
                    taken = 1+ dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(taken, notTaken);
            }
        }
        if(dp[len-1][amount] == Integer.MAX_VALUE) return -1;
        return dp[len-1][amount];
    }
}
