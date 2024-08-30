package DSA.Recursion.Medium;

import java.util.Arrays;

public class BetterString {
    public static String betterString(String str1, String str2) {
        // Code here
        int countSub1 = subs(0, "", str1, str1.length());
        int countSub2 = subs(0, "", str2, str2.length());
        return countSub1 > countSub2 ? str1 : str2;
    }

    private static int subs(int index, String strSoFar, String str, int len) {
        if(index==len) return 1;
        int count = 0;
        for(int i =index; i<len; i++){
            if(i == index || str.charAt(i)!= str.charAt(i-1)){
                strSoFar = strSoFar + str.charAt(i);
                count += subs(index+1, strSoFar, str, len);
                strSoFar = strSoFar.substring(0, strSoFar.length()-1);
            }
        }
        return count;
    }

    // optimized solution  ===> DP @TODO

    // Method to count distinct subsequences using dynamic programming
    private static int countDistinctSubsequences(String str) {
        int MOD = 1000000007;
        int n = str.length();

        // Array to store the last occurrence index of each character
        int[] lastOccurrence = new int[256];
        Arrays.fill(lastOccurrence, -1);

        // Dynamic programming array to store count of distinct subsequences
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one subsequence

        // Iterate through each character of the string
        for (int i = 1; i <= n; i++) {
            // Calculate count based on the recurrence relation
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Subtract count of subsequences ending at the last occurrence of the current character
            if (lastOccurrence[str.charAt(i - 1)] != -1) {
                dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i - 1)] - 1] + MOD) % MOD;
            }

            // Update last occurrence index of the current character
            lastOccurrence[str.charAt(i - 1)] = i;
        }

        // Return the final count of distinct subsequences
        return dp[n];
    }

}
