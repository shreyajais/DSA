package DSA.DynamicPrograming.StringsDP;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if(l1 == 0) return str2;
        if(l2 == 0) return str1;
        int[][] dp = countLCS(str1, str2, l1, l2);
        if(dp[l1][l2] == 0) return str1+str2;
        String strSoFar = "";
        int i = l1, j= l2;
        while(i>0 && j>0){
            if(dp[i][j] == dp[i-1][j]){
                strSoFar += str1.charAt(i-1);
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]){
                strSoFar += str2.charAt(j-1);
                j--;
            }
            else {
                strSoFar += str1.charAt(i-1);
                i--; j--;
            }
        }
        while(i>0){
            strSoFar += str1.charAt(i-1);
            i--;
        }
        while(j>0){
            strSoFar += str2.charAt(j-1);
            j--;
        }
        StringBuilder stb = new StringBuilder(strSoFar);
        stb.reverse();
        String ans = new String(stb);
        return ans;
    }

    private int[][] countLCS(String str1, String str2, int l1, int l2){
        int[][] dp = new int[l1+1][l2+1];
        for(int i =0; i<=l1; i++){
            dp[i][0] = 0;
        }
        for(int j =0; j<=l2; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }
}
