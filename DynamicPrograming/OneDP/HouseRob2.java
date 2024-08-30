package DSA.DynamicPrograming.OneDP;

public class HouseRob2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = dp2[0] = 0;
        dp1[1] = nums[0]; dp2[1] = nums[1];
        for(int i = 1; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+ nums[i-1]);
        }
        for(int i =2; i<n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
        }
        return Math.max(dp1[n], dp2[n]);
    }
}
