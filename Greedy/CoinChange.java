package DSA.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        if(n== 0) return -1;
        Arrays.sort(coins);
        int i = n-1, count = 0;
        while(i>=0){
            if(amount >=coins[i]){
                int numberOfCoins= amount/coins[i];
                count += numberOfCoins;
                amount -= numberOfCoins * coins[i];
            }
            i--;
            if(amount == 0) return count;
        }
        return -1;
    }

    /*
    int[][] dp = new int[len][amount+1];
        for(int i =1; i<=len; i++){
        dp[i][0]= 0;
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
    **/
}
