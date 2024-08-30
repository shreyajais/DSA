package DSA.DynamicPrograming.LIS;

import java.util.Arrays;

public class Bitonic {
    public static int LongestBitonicSequence(int n, int[] nums) {
        if(n==0) return 0;
        int[] lis = getLIS(n, nums);
        int[] reverseLis = getReverseLis(n, nums);
        int max = 0;
        for(int i =0; i<n; i++){
            if(lis[i]>1 && reverseLis[i] > 1)max = Math.max(max, lis[i] + reverseLis[i]-1);
        }
        return max;
    }
    public static int[] getLIS(int n, int[] nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i<n; i++){
            int max = 0;
            for(int j = 0; j<i; j++){
                if(nums[j]< nums[i] && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max +1;
        }
        return dp;
    }

    public static int[] getReverseLis(int n, int[] nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n-2; i>=0; i--){
            int max = 0;
            for(int j = n-1; j>i; j--){
                if(nums[j]< nums[i] && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max +1;
        }
        return dp;
    }
}
