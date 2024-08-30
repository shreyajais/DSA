package DSA.DynamicPrograming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length==0) return ans;
        int n = nums.length;
        int[] dp = new int[n]; // count number of divisible
        int[] lastDiv = new int[n];
        dp[0] = 1; lastDiv[0] = 0;
        for(int i = 1; i<n; i++){
            int max = 0, lastDivInd = i;
            for(int j = 0; j<i; j++){
                if(nums[i]%nums[j] == 0 && max < dp[j]){
                    max = dp[j];
                    lastDivInd = j;
                }
            }
            dp[i] = max +1;
            lastDiv[i] = lastDivInd;
        }
        int max = dp[0], lastDivInd = 0;
        for(int i =1; i<n; i++){
            if(max< dp[i]){
                max = dp[i];
                lastDivInd = i;
            }
        }
        while(true){
            ans.add(nums[lastDivInd]);
            if(lastDivInd == lastDiv[lastDivInd]) break;
            else lastDivInd = lastDiv[lastDivInd];
        }
        Collections.reverse(ans);
        return ans;
    }
}
