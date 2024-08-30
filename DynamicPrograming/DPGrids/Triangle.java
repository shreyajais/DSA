package DSA.DynamicPrograming.DPGrids;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j<=n; j++){
            dp[m][j] = triangle.get(m-1).get(j-1);
        }
        for(int i =m-1; i>= 1; i++){
            for(int j = 1; j<= i; j++){
                dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1]) + triangle.get(i-1).get(j-1);
            }
        }
        return dp[1][1];
    }
}
// [[2],[3,4],[6,5,7],[4,1,8,3]]
