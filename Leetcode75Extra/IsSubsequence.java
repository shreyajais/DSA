package DSA.Leetcode75Extra;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        for(int i = 0; i<=n1; i++) dp[i][0] = false;
        for(int j = 0; j<=n2; j++) dp[0][j] = false;
        dp[0][0] = true;
        for(int i =1; i<=n1; i++){
            for(int j = 1; j<=n2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n1][n2];
    }

}
