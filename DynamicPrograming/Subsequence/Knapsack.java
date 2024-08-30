package DSA.DynamicPrograming.Subsequence;

public class Knapsack {
    static int knapSack(int N, int W, int val[], int wt[])
    {
        if(W==0 || N == 0) return 0;
       int[][] dp =new int[N][W+1];
       for(int j =0;j<=W; j++){
           if(wt[0]<=j) dp[0][j] = (j/wt[0])*val[0];
       }
       for(int i = 1; i<N; i++){
           for(int j = 0; j<=W; j++){
               int notTaken = dp[i-1][j];
               int taken = 0;
               if(wt[i]<=j){
                   taken = val[i] + dp[i][j-wt[i]];
               }
               dp[i][j] = Math.max(taken, notTaken);
           }
       }
       return dp[N-1][W];
    }
}
