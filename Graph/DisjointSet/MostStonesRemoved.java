package DSA.Graph.DisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        // convert 2d matrix to 1d matrix and then finding independent componenets
        int maxRow = 0, maxCol = 0;
        Map<Integer, Integer> nodes = new HashMap<>(); // we can use set also hashMap used for easy iteration
        for(int i =0; i<stones.length; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        for(int i =0; i<stones.length; i++){
            int u = stones[i][0]; // row value
            int v = (stones[i][1] +1) + maxRow;
            ds.unionByRank(u, v);
            nodes.put(u, 1); nodes.put(v, 1);// // o based indexing ---> 7, 4---> u-> 7, v -> 12
        }
        int totalStones = stones.length;
        int uniqueNode = 0;
        for(Map.Entry<Integer, Integer> e: nodes.entrySet()){
            if(ds.findParent(e.getKey()) == e.getValue()) uniqueNode++;
        }
        return totalStones-uniqueNode;
    }
}
