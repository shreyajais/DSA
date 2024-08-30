package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurSubset(0, new ArrayList<>(), nums, ans, nums.length);
        return ans;
    }

    private void recurSubset(int index, ArrayList<Integer> arrSoFar, int[] nums, List<List<Integer>> ans, int len) {
        if(index== len){
            ans.add(new ArrayList<>(arrSoFar));
            return;
        }
        arrSoFar.add(nums[index]);
        recurSubset(index+1, arrSoFar, nums, ans, len);
        arrSoFar.remove(arrSoFar.size()-1);
        recurSubset(index+1, arrSoFar, nums, ans, len);
    }
}
