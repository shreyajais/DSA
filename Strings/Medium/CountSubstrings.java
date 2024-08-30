package DSA.Strings.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {
    long subStrCountAtMostK (String S, int K) {
        int start = 0;
        int n = S.length() ;
        int[] charFreq = new int[26];
        S = S.toLowerCase();
        int dist_count = 0 ;
        int countSubarrays = 0;
        for(int end = 0; end<n; end++){
            int c = S.charAt(end) -'a';
            charFreq[c]++;
            if(charFreq[c] == 1) dist_count++;
            while(start<end && dist_count>K){
                int cStart = S.charAt(start) -'a';
                charFreq[c]--;
                if(charFreq[c] == 0) dist_count--;
                start++;
            }
            countSubarrays += end-start+1;
        }
    }
}
