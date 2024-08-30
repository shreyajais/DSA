package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    // relaxation of edges by N-1 time --> n times if cyclic.
    int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S){
        int[] dist = new int[V];
        Arrays.fill(dist, (int)10e8);
        dist[S] = 0;
        for(int i =0; i<V; i++){
            for(ArrayList<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u] != (int)10e8 && dist[u] + wt < dist[v]) dist[v] = dist[u] + wt ;
            }
        }
        for(ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if(dist[u] != (int)10e8 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            };
        }
        return dist;
    }

}
