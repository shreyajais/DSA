package DSA.DynamicPrograming.StringsDP;

public class LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
      int l1 = s1.length();
      int l2 = s2.length();
      if(l1 == 0 || l2 == 0) return 0;
      int[][] dp = new int[l1+1][l2+1];
      for(int i =0; i<=l1; i++) dp[i][0] = 0;
      for(int j = 0; j<=l2; j++) dp[0][j] = 0;
      int maxValue = 0;
      for(int i = 1; i<=l1; i++){
          for(int j = 1; j<=l2; j++){
              if(s1.charAt(i-1) == s2.charAt(j-1)){
                  dp[i][j] = 1+dp[i-1][j-1];
                  maxValue = Math.max(maxValue, dp[i][j]);
              }
              else dp[i][j] = 0;
          }
      }
      return maxValue;
    }
}
