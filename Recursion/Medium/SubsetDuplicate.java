package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetDuplicate {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        subsetsWithDupRecur(0, new ArrayList<>(), nums, nums.length, ans);
        return ans;
    }

    private void subsetsWithDupRecur(int index, ArrayList<Integer> listSoFar, int[] nums, int length, List<List<Integer>> ans) {
        if(length == index){
            ans.add(new ArrayList<>(listSoFar));
            return;
        }
        listSoFar.add(nums[index]);
        subsetsWithDupRecur(index+1, listSoFar, nums, length, ans);
        listSoFar.remove(listSoFar.size()-1);
        int j = index+1;
        while(j < length && nums[index] == nums[j]) j++;
        subsetsWithDupRecur(j, listSoFar, nums, length, ans);
    }
}
