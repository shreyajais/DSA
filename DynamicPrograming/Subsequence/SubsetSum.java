package DSA.DynamicPrograming.Subsequence;

public class SubsetSum {
    // j====> sum, i =====> numbers
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];
        dp[0][0] = true;
        for(int i = 1; i<=N; i++){
            dp[i][0] = true;
        }
        for(int j =1; j<=sum; j++){
            dp[0][j]= false;
        }
        if(arr[0]<=sum){
            dp[1][arr[0]] = true;
        }
        for(int i = 2; i<=N; i++){
            for(int j = 1; j<=sum; j++){
                boolean notTaken = dp[i-1][j];
                boolean taken = false;
                if(arr[i-1]<=j){
                   taken = dp[i-1][j-arr[i-1]];
                }
                dp[i][j] = notTaken || taken;
            }
        }
        return dp[N][sum];
    }
}
