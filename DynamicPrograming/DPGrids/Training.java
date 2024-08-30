package DSA.DynamicPrograming.DPGrids;

public class Training {
    public int maximumPoints(int arr[][], int N) {
        // code here
        int[][] dp = new int[N+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        dp[1][0] = arr[0][0];
        dp[1][1] = arr[0][1];
        dp[1][2] = arr[0][2];
        for(int i = 2; i<= N; i++){
            dp[i][0] = arr[i-1][0] + Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i-1][1] + Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i-1][2] + Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
    }
}
