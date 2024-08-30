package DSA.HeapAndHashMap.Medium;

import java.util.PriorityQueue;

public class ReplaceWithRank {
    static class Pair implements Comparable<Pair>{
        int val; int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val-o.val;
        }
    }
    static int[] replaceWithRank(int arr[], int N) {
       int[] ans = new int[N];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for(int i =0; i<N; i++) pq.add(new Pair(arr[i], i));
        int rank = 1, lastVal = -1;
        while(!pq.isEmpty()){
            ans[pq.peek().index] = rank;
            if(lastVal !=pq.peek().val) rank++;
            lastVal = pq.remove().val;
        }
        return ans;
    }
}
