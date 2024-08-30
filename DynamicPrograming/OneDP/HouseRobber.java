package DSA.DynamicPrograming.OneDP;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0; if(n == 0) return 0;
        dp[1] = nums[0]; if(n == 1) return dp[1];
        dp[2] = Math.max(nums[0], nums[1]); if(n == 2) return dp[2];
        for(int i =3; i<=n; i++){
            // will rob this house + what ever collected with next to next house
            int val1 = nums[i-1] + dp[i-2];
            int val2 = dp[i-1];
            dp[i] = Math.max(val1, val2);
            // will not rob this house
        }
       return dp[n];
    }
}
