package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class DijkstraAlgorithm {
    class DistancePair{
        int node; int weight;
        DistancePair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
     int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        Comparator<DistancePair> weightComparator = new Comparator<DistancePair>() {
            @Override
            public int compare(DistancePair o1, DistancePair o2) {
                return o1.weight- o2.weight;
            }
        };
        PriorityQueue<DistancePair> pq = new PriorityQueue<>(weightComparator);
        pq.add(new DistancePair(S, 0));
        while(!pq.isEmpty()){
            DistancePair p = pq.poll();
            for(ArrayList<Integer> it: adj.get(p.node)){
                if((p.weight + it.get(1))< distance[it.get(0)]){
                    distance[it.get(0)] = p.weight + it.get(1);
                    pq.add(new DistancePair(it.get(0), p.weight+ it.get(1)));
                }
            }
        }
        for(int i=0; i<V; i++){
            if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        return distance;
    }
}
