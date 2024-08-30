package DSA.Graph;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFillFunc(int[][] grid, int srcI, int srcJ, int color){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0; i< m ; i++){
            Arrays.fill(visited[i], false);
        }
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        int initialColor = grid[srcI][srcJ];
        dfs(srcI, srcJ, grid, visited, dr, dc, color, initialColor, m , n);
        return grid;
    }

    public static void dfs(int nodeI, int nodeJ, int[][] grid, boolean[][] visited,  int[] dr, int[] dc, int color, int initialColor, int m, int n){
        grid[nodeI][nodeJ] = color;
        visited[nodeI][nodeJ] = true;
        for(int i =0; i<4; i++){
            int newI = nodeI + dr[i];
            int newJ = nodeJ + dc[i];
            if(isSafe(newI, newJ, m, n) && grid[newI][newJ] != 0 && grid[newI][newJ] == initialColor && visited[newI][newJ] == false){
                visited[newI][newJ] = true;
                dfs(newI, newJ, grid, visited, dr, dc, color, initialColor, m, n);
            }
        }
    }
    public static boolean isSafe(int i, int j ,int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
