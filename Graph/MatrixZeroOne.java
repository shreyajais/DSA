package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixZeroOne {
    class Pair{
        int i; int j; int steps;
        Pair(int i , int j, int steps){
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }

    public int[][]  matrixZeroOne(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dc = {-1, 0, 1, 0};
        int[] dr = {0, -1, 0, 1};
        boolean[][] visited = new boolean[m][n];
        for(int k =0; k< visited.length; k++){
            Arrays.fill(visited[k], false);
        }
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        for(int i =0; i < m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]== 0){
                    q.add(new Pair(i, j, 0));
                    dist[i][j] =0;
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int sizeQ = q.size();
            int steps = 0;
            for(int i =0; i<sizeQ; i++){
                Pair p = q.peek();
                q.remove();
                dist[p.i][p.j] = p.steps;
                for(int dir =0; dir<4; i++) {
                    int newI = p.i + dr[dir];
                    int newJ = p.j + dc[dir];
                    if(isSafe(newI, newJ, m, n) && grid[newI][newJ]== 1 && visited[newI][newJ] == false){
                        visited[newI][newJ] = true;
                        q.add(new Pair(newI, newJ, steps+1));
                    }
                }
            }
            steps++;
        }
        return dist;
    }
    public static boolean isSafe(int i, int j ,int m, int n){
        return i>0 && i<m-1 && j>0 && j<n-1;
    }
}
