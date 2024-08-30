package DSA.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubaaryXOR {
    public int solve(int[] A, int B) {
        int n = A.length;
        if(n == 0) return 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int xorSoFar = 0;
        mp.put(xorSoFar, 1);
        for(int i =0; i<n; i++){
            xorSoFar^= A[i];
            int resXor = xorSoFar^B;
            if(mp.containsKey(resXor)) count+= mp.get(xorSoFar^B);
            mp.put(xorSoFar, mp.getOrDefault(xorSoFar, 0)+1);
        }
        return count;
    }
}
