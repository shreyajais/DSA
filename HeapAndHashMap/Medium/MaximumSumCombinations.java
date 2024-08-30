package DSA.HeapAndHashMap.Medium;

import java.util.PriorityQueue;

public class MaximumSumCombinations {
    public int[] solve(int[] A, int[] B, int C) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<A.length; i++){
            for(int j =0; j<B.length; j++){
                int sum = A[i]+B[j];
                pq.add(sum);
                if(pq.size()>C) pq.remove();
            }
        }
        int[] ans = new int[C];
        int index = C-1;
        while(!pq.isEmpty()) ans[index--] = pq.remove();
        return ans;
    }
}
