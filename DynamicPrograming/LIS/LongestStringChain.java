package DSA.DynamicPrograming.LIS;

import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)-> a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int longestChain = 1;
        for(int i =1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(max<dp[j] && checkStringPredecessor(i, j , words)) max = dp[j];
            }
            dp[i] = max +1;
            longestChain = Math.max(longestChain, dp[i]);
        }
        return longestChain;
    }

    private boolean checkStringPredecessor(int i, int j, String[] words) {
        if(words[i].length() == words[j].length()) return words[i].equals(words[j]);
        int ind1 = 0, ind2 = 0;
        String str1 = words[i];
        String str2 = words[j];
        while(ind1<str1.length() && ind2<str2.length()){
            if(str1.charAt(ind1) == str2.charAt(ind2)){
                ind1++; ind2++;
            } else ind1++;
        }
        if(ind2 == str2.length()) return true;
        return false;
    }
}
