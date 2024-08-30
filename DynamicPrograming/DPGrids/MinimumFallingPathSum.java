package DSA.DynamicPrograming.DPGrids;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int i =1; i<=n; i++){
            dp[n][i] = matrix[n-1][i-1];
        }
        for(int i = n-1; i>=1; i++){
            for(int j = 1; j<=n ; i++){
                if(j == 1) dp[i][j] = matrix[i-1][j-1] + Math.min(dp[i+1][j] , dp[i+1][j+1]);
                else if(j == n) dp[i][j] = matrix[i-1][j-1] + Math.min(dp[i+1][j] , dp[i+1][j-1]);
                else dp[i][j] = matrix[i-1][j-1] + Math.min(dp[i+1][j] , Math.min(dp[i+1][j-1], dp[i+1][j+1]));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++){
            min = Math.min(dp[1][i], min);
        }
        return min;
    }
}
//directly below or diagonally left/right
