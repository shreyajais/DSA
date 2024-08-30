package DSA.DynamicPrograming.Subsequence;

public class PartitionSubSet {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int totalSum = 0;
        for(int i =0; i< N; i++){
            totalSum += nums[i];
        }
        if(totalSum%2 != 0) return false;
        int sum = totalSum/2;

        boolean[][]dp= new boolean[N+1][sum];
        dp[0][0] = true;
        for(int i = 1; i<=sum; i++) {
            dp[0][i] = false;
        }
        for(int i = 1; i<=N; i++){
            dp[i][0] = true;
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
        return dp[N][sum];
    }
}
