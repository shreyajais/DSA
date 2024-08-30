package DSA.DynamicPrograming.LIS;

import java.util.ArrayList;
import java.util.Collections;

public class PrintLIS {
        // method 3: just the length see method 4 where its just normal dp[] for lis at each i: where at last iterate to get the max.
        // method 4: print: dp[] : for lengthSoFa and hash[]: last smaller index, i: (0 to n) , prev: (0 to n-1) : dp[i]< dp[prev] + 1 && arr[i]> arr[prev]
        public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
            ArrayList<Integer> ans = new ArrayList<>();
            int[] dp = new int[n];
            int[] lastIndex = new int[n];
            dp[0] = 1; lastIndex[0] = -1;
            for(int i = 1; i<n; i++){
                int max = 0, lastIn = -1;
                for(int j = 0; j<i; j++){
                    if(arr[j]< arr[i] && max < dp[j]){
                        max = dp[j];
                        lastIn = j;
                    }
                }
                dp[i] = max +1;
                lastIndex[i] = lastIn;
            }
            int max = dp[0];
            int maxI = 0;
            for(int i =1; i<n; i++){
                if(max < dp[i]){
                    max = dp[i];
                    maxI = i;
                }
            }
            while(maxI!=-1){
                ans.add(arr[maxI]);
                maxI = lastIndex[maxI];
            }
            Collections.reverse(ans);
            return ans;
        }
}
