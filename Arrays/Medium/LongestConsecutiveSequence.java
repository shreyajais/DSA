package DSA.Arrays.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i =0; i<nums.length; i++) s.add(nums[i]);
        int max = 0;
        for(int i= 0; i< nums.length; i++){
            if(s.contains(nums[i]-1)) continue;
            else {
                int count = 0;
                int val = nums[i];
                while(s.contains(val)){
                    s.remove(val);
                    count++;
                    val = val+1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
