package DSA.DynamicPrograming.Subsequence;

public class RodCutting {
    public int cutRod(int price[], int n) {
        int priceLen = price.length;
      if(n==0 || priceLen== 0) return 0;
      int[][] dp = new int[priceLen+1][n+1];
      dp[0][0] = 0;
      for(int i =0; i<=priceLen; i++){
          dp[i][0] = 0; //  length of bar is zero
      }
      for(int j =1; j<=n; j++){
          dp[0][j] = 0; // length of price array is zero
          dp[1][j] = j*price[0]; // piece only len = 1
      }
      for(int i= 2; i<=priceLen; i++){
          for(int j = 1; j<=n; j++){
              int notTaken = dp[i-1][j];
              int taken = 0;
              if(i<=j){
                  taken = price[i-1] + dp[i][j-i];
              }
              dp[i][j] = Math.max(notTaken, taken);
          }
      }
      return dp[priceLen][n];
    }
}


