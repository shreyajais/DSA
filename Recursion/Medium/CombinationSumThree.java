package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum3Recur(1, 0, 0, new ArrayList<>(), k, n, ans);
        return ans;
    }
    private void combinationSum3Recur(int number, int count, int sumSoFar, ArrayList<Integer> listSoFar, int k, int n, List<List<Integer>> ans){
        if(sumSoFar == n && count == k){
            ans.add(new ArrayList<>(listSoFar));
            return;
        }
        else if(number == n || count > k || number == 10) return;
        else {
            listSoFar.add(number);
            combinationSum3Recur(number+1, count+1, sumSoFar+number, listSoFar, k, n, ans);
            listSoFar.remove(listSoFar.size()-1);
            combinationSum3Recur(number+1, count, sumSoFar, listSoFar, k, n, ans);
        }
    }
}
