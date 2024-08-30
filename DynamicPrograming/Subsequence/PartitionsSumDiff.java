package DSA.DynamicPrograming.Subsequence;

public class PartitionsSumDiff {
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for(int i= 0; i<n; i++){
            totalSum+= arr[i];
        }
        int sum = (totalSum + d)/2;
        return countSubsetSum(n, arr, sum);
    }

    private static int countSubsetSum(int n, int[] arr, int sum) {
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i = 1; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int j =1; j<=sum; j++){
            dp[0][j] = 0;
        }
        for(int i =1; i<=n; i++){
            for(int j =1; j<=sum; j++){
                if(j>=arr[i-1]) dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
}


