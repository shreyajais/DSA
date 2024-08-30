package DSA.DynamicPrograming.Square;

public class CountSquareSubMatricesAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int total = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])+1);
                    total+= dp[i][j];
                }
            }
        }
        return total;
    }




    public int countSquareMyTrial(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int total = 0;
        for(int i =0; i<m; i++){
            if(matrix[i][0] == 1){
                dp[i][0] = 1;
                total++;
            }
        }
        for(int i =0; i<n; i++){
            if(matrix[0][i] == 1){
                dp[0][i] = 1;
                total++;
            }
        }

        for(int i =1; i<m ; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j]==0) dp[i][j] = 0;
                else {
                    if(dp[i-1][j] == dp[i-1][j-1] && dp[i-1][j-1] == dp[i][j-1]) dp[i][j] = 1+ dp[i-1][j-1];
                    else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
                if(dp[i][j] > 0) total+= dp[i][j];
            }
        }
        return total;
    }
}
