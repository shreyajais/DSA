package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Bipartite {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj){
        int numOfNodes = adj.size();
        int[] pathVisited = new int[numOfNodes];
        Arrays.fill(pathVisited, 0);
        for(int i = 0; i<numOfNodes; i++){
            if(pathVisited[i] == 0){
                if(dfs(i, pathVisited, adj, 1)== false) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int[] pathVisited, ArrayList<ArrayList<Integer>> adj, int color){
        pathVisited[node] = color;
        for(int i =0; i<adj.get(node).size(); i++){
            int adjNode = adj.get(node).get(i);
            int newColor = getAlternateColor(color);
            if(pathVisited[adjNode]== 0){
                pathVisited[adjNode] = newColor;
                if(dfs(adjNode, pathVisited, adj, newColor)== false) return false;
                pathVisited[adjNode] = 0;
            } else if(pathVisited[adjNode] != 0 && pathVisited[adjNode] != newColor) return false;
        }
        return true;
    }
    public int getAlternateColor(int color){
        return color == 1? 2: 1;
    }
}