package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CycleInDirectedGraph {

    public ArrayList<Integer> getOrder(int[][] courses, int numOfCourses) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numOfCourses; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < courses.length; i++) {
            ans.get(courses[i][0]).add(courses[i][1]);
        }
        boolean[] visited = new boolean[numOfCourses];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numOfCourses; i++) {
            if (!visited[i]) {
                if (dfsIsCyclic(i, ans, visited, arr) == true) return new ArrayList<>();
            }
        }
        return arr;
    }

    public boolean dfsIsCyclic(int node, ArrayList<ArrayList<Integer>> ans, boolean[] visited, ArrayList<Integer> arr){
        visited[node] = true;
        arr.add(node);
        for(int it: ans.get(node)){
            if(visited[it]) return true;
            else if(dfsIsCyclic(it, ans, visited, arr)== true) return true;
        }
        return false;
    }
}

        public boolean isCycleUtil(boolean[] visited, boolean[] curRec, int i) {

            if (visited[i] == false) {

                visited[i] = true;
                curRec[i] = true;
                for (Integer v : edges.get(i)) {

                    if (!visited[v] && isCycleUtil(visited, curRec, v))
                        return true;
                    else if (curRec[v])
                        return true;
                }
                l.add(new Integer(i));
            }

            curRec[i] = false;

            return false;
        }
    }
