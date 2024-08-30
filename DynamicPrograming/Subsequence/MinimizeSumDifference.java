package DSA.DynamicPrograming.Subsequence;

import java.util.Arrays;

public class MinimizeSumDifference {
    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int totalSum = 0;
        for(int i =0; i< N; i++){
            totalSum += nums[i];
        }
        int sum = totalSum/2;

        boolean[][]dp= new boolean[N+1][sum+1];
        dp[0][0] = true;
        for(int i = 1; i<=sum; i++) {
            dp[0][i] = false;
        }
        for(int i = 1; i<=N; i++){
            dp[i][0] = true; // this is important that sum = 0 when in subset no one is there
        }
        if(nums[0]<=sum){
            dp[1][nums[0]] = true;
        }
        for(int i = 2; i<=N; i++){
            for(int j = 1; j<=sum; j++){
                boolean notTaken = dp[i-1][j];
                boolean taken = false;
                if(nums[i-1]<j){
                    taken = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = taken || notTaken;
            }
        }
        for(int j = sum; j>=0; j++){
            if(dp[N][j]) return Math.abs(totalSum - j);
        }
        return totalSum;
    }
}

/*
* int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum + 1];

        // Initialize the DP table for the first row
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the DP table for the first column
        if (arr.get(0) <= totSum) {
            dp[0][totSum] = true;
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }*/
