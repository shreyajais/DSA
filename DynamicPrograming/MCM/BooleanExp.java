package DSA.DynamicPrograming.MCM;

public class BooleanExp {
    int mod = (int)10e7;
    public int parseBoolExpr(String expression) {
        int len = expression.length();
        char[] exp = expression.toCharArray();
        int[][][] dp = new int[len+1][len+1][2];
        return waysFunc(exp, dp, 0, len-1, true);
    }

    private int waysFunc(char[] exp, int[][][] dp, int i, int j, boolean isTrue) {
        if(i>j) return 0;
        if(i==j){
            if(isTrue) return exp[i] == 'T' ? 1: 0;
            else return exp[i] == 'F' ? 1: 0;
        }
        int ways = 0;
        for(int ind = i+1; ind<=j-1; i++){
            char ch = exp[ind];
            int LT = waysFunc(exp, dp, i, ind-1, true);
            int RT = waysFunc(exp, dp, ind+1, j, true);
            int LF = waysFunc(exp, dp, i, ind-1, false);
            int RF = waysFunc(exp, dp, ind+1, j, false);

           if(ch == '&'){
               if(isTrue) ways += LT%mod * RT%mod;
               else ways += LT%mod * RF%mod + LF%mod * RT%mod + LF%mod * RF%mod;
           } else if(ch == '|'){
               if(isTrue) ways += LT%mod * RF%mod + LF%mod * RT%mod + LT%mod * RT%mod;
               else ways += LF%mod * RF%mod;
           }else {
               if(isTrue) ways += LT%mod * RF%mod + LF%mod * RT%mod;
               else ways += LT%mod * RT%mod + LF%mod * RF%mod;
           }
        }
        dp[i][j][1] = ways;
        return ways;
    }


}
