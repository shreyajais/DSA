package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        for(int i =0; i< len; i++){
            if(!used[i]){
                permuteRecur(i, used, new ArrayList<>(), ans, len, nums);
            }
        }
        return ans;
    }
    private void permuteRecur(int index, boolean[] used, ArrayList<Integer> listSoFar, List<List<Integer>> ans, int len, int[] nums){
        if(listSoFar.size() == len){
            ans.add(new ArrayList<>(listSoFar));
            return;
        }
        listSoFar.add(nums[index]);
        used[index] = true;
        for(int i =0; i<len; i++){
            if(!used[i]) permuteRecur(i, used, listSoFar, ans, len, nums);
        }
    }
}
