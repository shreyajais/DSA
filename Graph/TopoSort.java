package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopoSort {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for(int j =0; j<V; j++){
            if(visited[j]==false)
                dfs(j, st, visited, adj, V);
        }
        int[] topo = new int[V];
        int index =0;
        while(!st.isEmpty()){
            topo[index] = st.peek();
            st.pop();
            index++;
        }
        return topo;
    }
    static void dfs(int node, Stack<Integer> st, boolean[] visited, ArrayList<ArrayList<Integer>> ans, int V){
        visited[node] = true;
        for(int it: ans.get(node)){
            if(visited[it] == false){
                dfs(it, st, visited, ans, V);
            }
        }
        st.add(node);
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

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
