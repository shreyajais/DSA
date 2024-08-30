package DSA.DynamicPrograming.OneDP;

public class JumpK {
    public int minimizeCost(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i =0; i<k; i++) dp[0] = arr[i];
        for(int i =k; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j =1; j<=k; j++) min = Math.min(min, dp[i-j]);
            dp[i] = arr[i] + min;
        }
        return dp[n-1];
    }
}
