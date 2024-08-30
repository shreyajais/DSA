package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathNonDirected {
    class Pair{
        int edge; int step;
        Pair(int edge, int step){
            this.edge = edge;
            this.step = step;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = getAdjList(edges, n);
        int[] distance = new int[n];
        for(int i = 0;i<n;i++) distance[i] = (int)1e9;

        boolean[] visited = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        distance[src] = 0;
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            for(int it: adj.get(p.edge)){
                if(p.step+ 1 < distance[it]){
                    distance[it] = p.step+1;
                    q.add(new Pair(it, p.step+1));
                }
            }
        }
        for(int it: distance){
            if(distance[it] == (int)1e9) distance[it] = -1;
        }
        return distance;
    }

    public ArrayList<ArrayList<Integer>> getAdjList(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i =0; i<n; i++){
            ans.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            ans.get(edges[i][0]).add(edges[i][1]);
            ans.get(edges[i][1]).add(edges[i][0]);
        }
        return ans;
    }
}
