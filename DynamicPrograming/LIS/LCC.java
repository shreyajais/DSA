package DSA.DynamicPrograming.LIS;

public class LCC {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i<n; i++){
            int max = 0;
            for(int j = 0; j<i; j++){
                if(nums[j]< nums[i] && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max +1;
        }
        int max = dp[0];
        for(int i =1; i<n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
