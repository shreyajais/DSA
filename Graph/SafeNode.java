package DSA.Graph;

import java.util.*;

public class SafeNode {


        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> safe = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            int[] indegree = new int[graph.length];
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i =0; i<graph.length; i++){
                arr.add(new ArrayList<>());
            }
            for(int i =0; i<graph.length; i++){
                for(int j =0; j<graph[i].length; j++){
                    arr.get(graph[i][j]).add(i);
                    indegree[i]++;
                }
            }
            for(int i =0; i< indegree.length; i++){
                if(indegree[i]==0) q.add(i);
            }
            while(!q.isEmpty()){
                int x = q.peek();
                safe.add(x);
                q.remove();
                for(int it: arr.get(x)){
                    indegree[it]--;
                    if(indegree[it]==0) q.add(it);
                }
            }
            Collections.sort(safe);
            return safe;
        }
}
