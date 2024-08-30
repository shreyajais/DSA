package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumDuplicate {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationSum(0, 0, new ArrayList<>(), target, candidates, candidates.length, ans);
        return ans;
    }

    private void getCombinationSum(int index, int sumSoFar, ArrayList<Integer> listSoFar, int target, int[] candidates, int length, List<List<Integer>> ans) {
        if(sumSoFar == target){
            ans.add(new ArrayList<>(listSoFar));
            return;
        }
        if(index==length) return;
        if(target-sumSoFar<candidates[index]) return;
        for(int i =index; i<candidates.length; i++){
            if(index == i || candidates[i-1]!= candidates[i]){
                listSoFar.add(candidates[i]);
                getCombinationSum(i+1, sumSoFar + candidates[i], listSoFar, target, candidates, length, ans);
                listSoFar.remove(listSoFar.size()-1);
            }
        }
    }
}
