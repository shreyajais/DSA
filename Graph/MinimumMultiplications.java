package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumMultiplications {
    class Pair{
        int newStart; int steps;

        public Pair(int newStart, int steps) {
            this.newStart = newStart;
            this.steps = steps;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start== end) return 0;
        int mod = 100000;
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.newStart>end) continue;
            if(p.newStart == end) return p.steps;
            for(int i = 0; i<arr.length; i++){
                int value = (p.newStart * arr[i]) %mod;
                if(dist[value]> p.steps+1)pq.add(new Pair(value, p.steps+1));
            }
        }
        return 0;
    }
}
