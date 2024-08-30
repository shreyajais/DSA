package DSA.DynamicPrograming.StringsDP;

import java.util.*;

public class PrintLCS {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int[][] lcs = longestCommonSubsequence(s, t);
        Set<String> strSet = new HashSet<>();
        getSubsequences(s.length(), t.length(), "", s, t, lcs, strSet);
        List<String> ans = new ArrayList<>();
        ans.addAll(strSet);
        Collections.sort(ans);
        return ans;
    }

    public void getSubsequences(int i , int j, String strSoFar, String s, String t, int[][] lcs, Set<String> ans){
        if(j<=0 || i<=0) ans.add(new StringBuilder(strSoFar).reverse().toString());
        if(s.charAt(i - 1) == t.charAt(j - 1)){ // lcs[i][j] == lcs[i-1][j-1]+1 this is wrong as can contain other cases too.
            strSoFar += s.charAt(i-1);
            getSubsequences(i-1, j-1, strSoFar, s, t, lcs, ans);
        } else {
            if(lcs[i][j]== lcs[i-1][j]) getSubsequences(i-1, j, strSoFar, s, t, lcs, ans);
            if(lcs[i][j]== lcs[i][j-1]) getSubsequences(i, j-1, strSoFar, s, t, lcs, ans);
        }
    }
    public int[][] longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        if(l1==0 || l2 == 0)  return dp;
        for(int i =0; i<l1; i++){
            dp[i][0] = 0;
        }
        for(int j =0; j<=l2; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }
}
