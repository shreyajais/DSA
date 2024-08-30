package DSA.DynamicPrograming.MCM;
import java.util.*;
public class MinCostCutStick {
    // adding 0 in front make 0 based to 1 based index and c == cuts ka last element.
// range from 1 to c===> f(i, i-1 ) + f(i+1, j) as option j is destroyed + length(j+1 to i-1) ==> (n-0)

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int num: cuts) arr.add(num);
        arr.add(n);
        Collections.sort(arr);
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return func(cuts, 1, cuts.length, dp, arr);
    }
    private int func(int[] cuts, int c1, int c2, int[][] dp, ArrayList<Integer> arr){
        if(c1>c2) return 0;
        if(dp[c1][c2] !=-1) return dp[c1][c2];
        int min = Integer.MAX_VALUE;
        for(int c = c1; c<= c2; c++){
            int len = arr.get(c2+1) - arr.get(c1-1);
            int value = len + func(cuts, c1, c-1, dp, arr) + func(cuts, c+1, c2, dp, arr);
            min = Math.min(min, value);
        }
        return dp[c1][c2] = min;
    }



}
