package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    class Pair{
        int dest; int time;
        Pair(int dest, int time){
            this.dest = dest;
            this.time = time;
        }
    }
    class DiscoveryNode{
        int node; int timeSoFar;
        DiscoveryNode(int node, int timeSoFar){
            this.node = node;
            this.timeSoFar = timeSoFar;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = getAdjList(times, n);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<DiscoveryNode> pq = new PriorityQueue<>((a,b)-> a.timeSoFar - b.timeSoFar);
        pq.add(new DiscoveryNode(k, 0));

        while(!pq.isEmpty()){
            DiscoveryNode discoveryNode = pq.poll();
            for(Pair it: adj.get(discoveryNode.node)){
                if((it.time + discoveryNode.timeSoFar)< dist[it.dest]){
                    dist[it.dest] = it.time + discoveryNode.timeSoFar;
                    pq.add(new DiscoveryNode(it.dest, it.time + discoveryNode.timeSoFar));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i< dist.length; i++){
            if(dist[i]== Integer.MAX_VALUE) return -1;
            else if(max< dist[i]) max = dist[i];
        }
        return max;
    }

    private ArrayList<ArrayList<Pair>> getAdjList(int[][] times, int n) {
        ArrayList<ArrayList<Pair>> ans = new ArrayList<>();
        for(int i =0; i<n; i++) ans.add(new ArrayList<>());
        for(int i =0; i<times.length; i++){
            ans.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        return ans;
    }
}
