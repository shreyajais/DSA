package DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        int start = 0, end = 0;
        while(end< nums.length){
            while(nums[end] + 1 == nums[end+1]) end++;
            if(start == end) ans.add("" + nums[end]);
            else ans.add("" + nums[start] + "->" + nums[end]);
            start = end +1;
            end = start;
        }
        return ans;
    }
}
