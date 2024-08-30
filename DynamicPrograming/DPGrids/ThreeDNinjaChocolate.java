package DSA.DynamicPrograming.DPGrids;

public class ThreeDNinjaChocolate {
    public int solve(int n, int m, int grid[][]) {

    }
    public int maxCollection(int n, int m , int grid[][]){
        int[][][] dp = new int[n][m][2];
        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                if(j==0){
                    dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j+1][0];
                }
                if(j==n-1) dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j-1][0];
                else dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j-1][0] + dp[i-1][j+1][0];
            }
        }
    }
}
// 1 -> left priority 2 -> right priority
