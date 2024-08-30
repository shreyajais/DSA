package DSA.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;
        Arrays.sort(nums);
        int i = 0;
        while(i<=n-3){
            while(i!=0 && nums[i] == nums[i-1]) i++;
            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]); l.add(nums[j]); l.add(nums[k]);
                    ans.add(l);
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
                else if(sum< 0) {
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                } else {
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
            i++;
        }
        return ans;
    }
}
