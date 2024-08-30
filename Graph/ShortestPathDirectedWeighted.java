package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathDirectedWeighted {
    class Pair{
        int node; int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    class DistancePair{
        int node; int weight;
        DistancePair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        //Code here
        ArrayList<ArrayList<Pair>> adj = getAdjList(edges, N);
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        Comparator<DistancePair> weightComparator = new Comparator<DistancePair>() {
            @Override
            public int compare(DistancePair o1, DistancePair o2) {
                return o1.weight- o2.weight;
            }
        };
        PriorityQueue<DistancePair> pq = new PriorityQueue<>(weightComparator);
        pq.add(new DistancePair(0, 0));
        while(!pq.isEmpty()){
            DistancePair p = pq.poll();
            for(Pair it: adj.get(p.node)){
                if((p.weight + it.weight)< distance[it.node]){
                    distance[it.node] = p.weight + it.weight;
                    pq.add(new DistancePair(it.node, p.weight + it.weight));
                }
            }
        }
        for(int i: distance){
            if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        return distance;
    }

    public ArrayList<ArrayList<Pair>> getAdjList(int[][] edges, int n){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<n; i++) adj.add(new ArrayList<>());
        for(int i =0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        return adj;
    }
}
