package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
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
            listSoFar.add(candidates[index]);
            getCombinationSum(index, sumSoFar + candidates[index], listSoFar, target, candidates, length, ans);
            //getCombinationSum(index+1, sumSoFar + candidates[index], listSoFar, target, candidates, length, ans); ///@REMEMBER
            listSoFar.remove(listSoFar.size()-1);
        getCombinationSum(index+1, sumSoFar, listSoFar, target, candidates, length, ans);
    }
}
