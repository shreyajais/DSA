package DSA.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DistinctIsland {
    public int getDistinctIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && grid[i][j]== 1){
                    count++;
                    dfs(i, j, visited, dr, dc, grid, m, n);
                }
            }
        }
        return count;
    }

    public void dfs(int nodeI, int nodeJ, boolean[][] visited, int[] dr, int[] dc, int[][] grid, int m, int n){
        visited[nodeI][nodeJ] = true;
        for(int i =0; i<8; i++){
            int newI = nodeI + dr[i];
            int newJ = nodeJ + dc[i];
            if(isSafe(newI, newJ, m, n) && !visited[newI][newJ] && grid[newI][newJ] == 1) dfs(newI, newJ, visited, dr, dc, grid, m, n);
        }
    }

    public void bfs(int nodeI, int nodeJ, boolean[][] visited, int[] dr, int[] dc, int[][] grid, int m , int n){
        visited[nodeI][nodeJ] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(nodeI, nodeJ ));
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            for(int i =0; i<8; i++){
                int newI = p.r + dr[i];
                int newJ = p.c + dc[i];
                if(isSafe(newI, newJ, m, n) && !visited[newI][newJ] && grid[newI][newJ] == 1) q.add(new Pair(newI, newJ));
            }
        }
    }

    class Pair{
        int r; int c;
        Pair(int r, int c){
            this.r = r;
            this.c =c;
        }
    }

    public static boolean isSafe(int i, int j ,int m, int n){
        return i>0 && i<m-1 && j>0 && j<n-1;
    }
}
