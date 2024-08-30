package DSA.DynamicPrograming.StringsDP;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(l1 == 0 || l2 == 0) return 0;
        int[][] dp = new int[l1+1][l2+1];
        for(int i =0; i<=l1; i++){
            dp[i][0] = 1;
        }
        for(int j =0; j<=l2; j++){
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; // when math take f(take match) + f(not match case)
                } else dp[i][j] = dp[i-1][j]; // when cannot match try for ways from rest of the string
            }
        }
        return dp[l1][l2];
    }

}
