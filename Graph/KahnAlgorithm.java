package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class KahnAlgorithm {

    static int[] topoSortKahn(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);
        for(int i =0; i<adj.size(); i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }
        // add all the nodes with in-degree = 0
        for(int ind = 0; ind<V; ind++){
            if(inDegree[ind] == 0) q.add(ind);
        }
        return kahnTopoAlgo(q, inDegree, adj, V);
    }

    private static int[] kahnTopoAlgo(Queue<Integer> q, int[] inDegree, ArrayList<ArrayList<Integer>> adj, int V) {
        int[] ans = new int[V];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            ans[index] = node;
            index++;
            q.remove();
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]== 0) q.add(it);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSortKahn(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}