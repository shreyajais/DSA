package DSA.DynamicPrograming.Subsequence;

public class CountSubsetSumK {
    public int perfectSum(int arr[],int n, int sum)
    {
      int[][] dp = new int[n+1][sum+1];
      dp[0][0] = 1;
      for(int i = 1; i<=n; i++){
          dp[i][0] = 1;
      }
      for(int j =1; j<=sum; j++){
          dp[0][j] = 0;
      }
        if(arr[0]<=sum) dp[1][arr[0]] = 1;
        if(arr[0] == 0){
            dp[1][0] = 2;
        }
      for(int i =2; i<=n; i++){
          for(int j =1; j<=sum; j++){
              if(j>=arr[i-1]) dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
              else dp[i][j] = dp[i-1][j];
          }
      }
      return dp[n][sum];
    }
}