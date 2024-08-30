package DSA.DynamicPrograming.MCM;

import java.util.Arrays;

public class PartitionArrayMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxMaxSum(arr, k, n, dp, 0);
    }

    private int maxMaxSum(int[] arr, int k, int n, int[] dp, int start) {
        if(start== n) return 0;
        if(dp[start] != -1) return dp[start];
        int maxSum = 0;
        for(int p = start; p<= Math.min(start + k -1, n-1); p++){
            int maxVal = Integer.MIN_VALUE;
            for(int i = start; i<=p; i++){
                maxVal = Math.max(arr[i], maxVal);
            }
            int maxValSum = ((p - start +1) * maxVal) + maxMaxSum(arr, k, n, dp, p+1);
            maxSum = Math.max(maxValSum, maxSum);
        }
        return dp[start] = maxSum;
    }
}
