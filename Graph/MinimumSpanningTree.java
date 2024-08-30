package DSA.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    // ST: here we can reach all nodes from all node.
    // MST: St sum of wt of all edges is min.
    // application: prims--> sum of all edges of mst using pq
    static class Edge implements Comparable<Edge>{
        int node; int wt;

        public Edge(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] nodesVisited = new boolean[adj.size()];
        int mstWt = 0;
        pq.add(new Edge(0,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(nodesVisited[e.node]) continue;
            nodesVisited[e.node] = true;
            mstWt += e.wt;
            for(int j= 0; j<adj.get(e.node).size(); j++){
                int adjNode = adj.get(e.node).get(j)[0];
                if(!nodesVisited[adjNode]) pq.add(new Edge(adjNode, adj.get(e.node).get(j)[1]));
            }
        }
        return mstWt;
    }


}
