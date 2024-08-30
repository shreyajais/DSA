package DSA.DynamicPrograming.MCM;

import java.util.Arrays;

public class Basic {
    // f(int[] arr, int i(1), int j(N-1))
    // BC: i== j  return 0 so it's not  a matrix
    // partioning loop   for(int k = i; k<= j-1; k++){int ans = f(arr,i,k) + f(arr, k+1,j) + arr[i-1]*arr[k]*arr[j]; mini = Math.min(mini,ans);
    // int[][] dp = new int[N][N];
    // meaning of a cell d[i][j] ==> f(0, i) and f(i+1, n-1)
    // for(int k = i; k<= j-1; k++)int ans = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
    // return dp[1][N - 1];

            // Fill in the dp array using bottom-up approach
    public int mcm(int[] arr, int n){
        int i = 1, j = n-1;
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);// 1 ===> (0,1)--> single matrix.
        return mcmDp(arr, i, j, dp);

    }
    private int mcmDp(int[] arr, int i , int j, int[][] dp){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            int mult = mcmDp(arr, i, k, dp) + mcmDp(arr, k, j-1, dp) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(mult, min);
        }
        return dp[i][j] = min;
    }
}
