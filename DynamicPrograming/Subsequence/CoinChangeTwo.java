package DSA.DynamicPrograming.Subsequence;

public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 0;
        int n = coins.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][amount+1];
        for(int j = 0; j<=amount; j++){
            if(j%coins[0]==0) dp[j][coins[0]] = j/coins[0];
            else dp[j][coins[0]] = 0;
        }
        for(int i =0; i<n; i++){
            for(int j = 1; j<=amount; j++){
                int notTaken = dp[i-1][j];
                int taken = 0;
               if(j>=coins[i]){
                   taken = dp[i][j-coins[i]];
               }
                dp[i][j] = notTaken + taken;
            }
        }
        return dp[n-1][amount];
    }
}
