package DSA.DynamicPrograming.MCM;

import java.util.Arrays;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutRecur(s, dp, 0, n-1, n)-1;
    }

    private int minCutRecur(String s, int[] dp, int i, int j, int n) {
        if(i==n) return 0;
        if(dp[i] !=-1) return dp[i];
        int cutWays = Integer.MAX_VALUE;
        for(int cut = i; cut<=j; cut++){
            if(isPalindrome(s, i, cut)){
                int cutAtICount = 1+ minCutRecur(s, dp, cut+1, j, n);
                cutWays = Math.min(cutWays, cutAtICount);
            }
        }
        dp[i] = cutWays;
        return cutWays;
    }

    private boolean isPalindrome(String s, int i, int j) {
        int start = i, end = j;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
