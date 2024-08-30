package DSA.DynamicPrograming.LIS;

import java.util.Arrays;

public class CountLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        int[] numberOfSubArrayMakingLis = new int[n];
        int lisLength = 1;
        Arrays.fill(dp,1);
        // the subarray count will be 1 where the length == 1
        Arrays.fill(numberOfSubArrayMakingLis, 1);
        for(int i =1; i<n; i++){
            int lisCount = 0;
            int max = 0;
            for(int j =0; j<i; j++){
               if(nums[i]>nums[j]){
                   if(max > dp[j]){
                       max = dp[j];
                       lisCount = numberOfSubArrayMakingLis[j];
                   } else if(max == dp[j]){
                       lisCount += numberOfSubArrayMakingLis[j];
                   }
               }
            }
            dp[i] = max +1;
            numberOfSubArrayMakingLis[i] = lisCount;
            lisLength = Math.max(lisCount, dp[i]);
        }
        int count = 0;
        for(int i =0; i<n; i++){
            if(dp[i] == lisLength) count+= numberOfSubArrayMakingLis[i];
        }
        return count;
    }
}
