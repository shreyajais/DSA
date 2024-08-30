package DSA.DynamicPrograming.StringsDP;

public class MinInsertMakePalindrome {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        String s2 = (new StringBuilder(s).reverse().toString());
        return longestCommonSubsequence(s, s2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
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
        return dp[l1][l2];
    }
}
