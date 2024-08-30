package DSA.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;
        Arrays.sort(nums);
        for(int i =0; i<=n-4; i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<=n-3; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k<l){
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> group = new ArrayList<>();
                        group.add(nums[i]); group.add(nums[j]); group.add(nums[k]); group.add(nums[l]);
                        ans.add(group);
                        k++;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        l--;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum< target) {
                        k++;
                        while(k<l && nums[k] == nums[k-1]) k++;
                    } else {
                        l--;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
