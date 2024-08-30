package DSA.StackQueue.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbers {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n-B+1];
        if(B==1){
            Arrays.fill(ans, 1);
            return ans;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i =0; i<B; i++) mp.put(A[i], mp.getOrDefault(A[i], 0)+1);
        ans[0] = mp.size();
        for(int curr = B, prev = 0; curr<n; curr++){

        }
    }
}
