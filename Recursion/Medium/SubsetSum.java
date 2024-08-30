package DSA.Recursion.Medium;

import java.util.ArrayList;

public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSumsRecur(0, 0, arr, n, ans);
        return ans;
    }

    private void subsetSumsRecur(int index, int sumSoFar, ArrayList<Integer> arr, int n, ArrayList<Integer> ans) {
        if(n == index){
            ans.add(sumSoFar);
            return;
        }
        subsetSumsRecur(index+1, sumSoFar + arr.get(index), arr, n, ans);
        subsetSumsRecur(index+1, sumSoFar, arr, n, ans);
    }

}
