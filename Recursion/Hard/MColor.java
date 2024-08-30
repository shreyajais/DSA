package DSA.Recursion.Hard;

import java.util.*;

public class MColor {

    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        ArrayList<ArrayList<Integer>> adjList = getAdjList(graph, n);
        if(isColoringSafe(0, adjList, new int[n], m, n)) return true;
        return false;
    }

    private boolean isColoringSafe(int node, ArrayList<ArrayList<Integer>> adjList, int[] color, int m, int n) {
        if(node==n) return true;
        for(int i =1; i<=m; i++){
            if(isSafe(node, adjList, i, color, n)){
                color[node] = i;
                if(isColoringSafe(node+1, adjList, color, m, n)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int node, ArrayList<ArrayList<Integer>> adjList, int i, int[] color, int n) {
        for(int adjNode: adjList.get(node)){
            if(color[adjNode] == i) return false;
        }
        return true;
    }

    private ArrayList<ArrayList<Integer>> getAdjList(boolean[][] graph, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i =0; i<graph.length; i++) ans.add(new ArrayList<>());
        for(int i =0; i<graph.length; i++){
            for(int j =0;j<graph[0].length; j++){
                if(graph[i][j]) {
                    ans.get(i).add(j); ans.get(j).add(i);
                }
            }
        }
        return ans;
    }
}
