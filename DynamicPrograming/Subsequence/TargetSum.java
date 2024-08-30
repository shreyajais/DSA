package DSA.DynamicPrograming.Subsequence;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i =0; i<n; i++) sum = sum+nums[i];
        char[][] dp = new char[n][2*sum+1];
        dp[0][sum + nums[0]] = '+';
        dp[0][sum-nums[0]] = '-';
        for(int i =1; i<n; i++){
            dp[i][sum + nums[0]] = dp[i-1]
        }

    }
}
