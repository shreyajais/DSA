package DSA.DynamicPrograming.DPGrids;

public class MaxPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i =0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int i =0; i<=n; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(i == 1 && j ==1) dp[i][j] = grid[1][1];
                else if(i == 1) dp[i][j] = grid[i-1][j-1] + dp[i][j-1];
                else if(j== 1) dp[i][j] = grid[i-1][j-1] + dp[i-1][j];
                dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
