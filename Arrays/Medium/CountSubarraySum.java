package DSA.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int N = nums.length;
        if(N==0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int sumSoFar = 0;
        mp.put(sumSoFar, 1);
        for(int i =0; i<N; i++){
            sumSoFar+= nums[i];
            if(nums[i] == k) count++;
            else if(sumSoFar== k) count++;
            else if(mp.containsKey(sumSoFar-k)) count += mp.get(sumSoFar-k);
            if(!mp.containsKey(sumSoFar)) mp.put(i, 1);
            else mp.put(i, mp.get(sumSoFar)+1);
        }
        return count;
    }
}
