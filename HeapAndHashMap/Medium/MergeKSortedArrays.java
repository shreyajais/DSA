package DSA.HeapAndHashMap.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class  Pair implements Comparable<Pair> {
        int listI; int ind; int val;

        public Pair(int listI, int ind, int val) {
            this.listI = listI;
            this.ind = ind;
            this.val = val;
        }
        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0; i<arr.length; i++) pq.add(new Pair(i, 0, arr[i][0]));
        while (!pq.isEmpty()){
            if(pq.peek().ind<(arr[pq.peek().listI].length-1)){
                pq.add(new Pair(pq.peek().listI, pq.peek().ind+1, arr[pq.peek().listI][pq.peek().ind+1]));
            }
            ans.add(pq.remove().val);
        }
        return ans;
    }
}
