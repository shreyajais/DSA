package DSA.DynamicPrograming.DPGrids;

public class uniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i =0; i<=m; i++){
            dp[i][0] =0;
        }
        for(int i =0; i<=n; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(i == 1 && j == 1) dp[i][j] = 1;
                else if(obstacleGrid[i-1][j-1] == 1 ) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
