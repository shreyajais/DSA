package DSA.DynamicPrograming.Intro;

import java.util.Arrays;

public class TopBottom {
    static long topDown(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        topDownDp(n, dp);
        return dp[n];
    }

    private static int topDownDp(int n, int[] ans) {
        if(n == 0 || n == 1) {
            ans[n] = n;
            return n;
        }
        else if(ans[n] != -1) return ans[n];
        else return ans[n] = topDownDp(n-1, ans) + topDownDp(n-2, ans);
    }

    static long bottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
