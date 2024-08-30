package DSA.DynamicPrograming.LIS;

import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) return true;
        if(p.length()==0) return false;
        if(s.length() == 0) return ifAllStars(p);
        if(s.equals(p)) return true;
        int sLen = s.length();
        String P = getPattern(p);
        int pLen = P.length();
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        for(int i=0; i<=pLen; i++){
            Arrays.fill(dp[i], false);
        }
        int start = 1;
        if(P.charAt(0) == '*'){
            for(int i = 0; i<=sLen; i++) dp[1][i] = true;
            start = 2;
        }
        for(int i = start; i<=pLen; i++){
            for(int j =1; j<=sLen; j++){
                if(P.charAt(i-1) == s.charAt(j-1) || P.charAt(i-1) == '?') dp[i][j] = dp[i-1][j-1];
                if(p.charAt(i-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[pLen+1][sLen+1];
    }

    private boolean ifAllStars(String p) {
        for(int i =0; i<p.length(); i++){
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }

    private String getPattern(String p) {
        String strSoFar = "";
        int count = 0;
        for(int i =0; i<p.length(); i++){
            if(p.charAt(i) == '*'){
                if(count == 0){
                    strSoFar += '*';
                    count++;
                } else continue;
            } else{
                strSoFar += p.charAt(i);
                count = 0;
            }
        }
        return strSoFar;
    }

}
