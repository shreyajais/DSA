package DSA.Graph;

public class NumberOfEnclaves {

    public int getNumberOfEnclaves(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dc = {-1, 0, 1, 0};
        int[] dr ={0, -1, 0, 1};
        for(int i1 =0; i1<n; i1++){
            if(grid[0][i1]==  1) dfs(0, i1, visited, dc, dr, grid, m, n);
            if(grid[0][m-1]== 1) dfs(m-1, i1, visited, dc, dr, grid, m, n);
        }
        for(int j1 =0; j1<m; j1++){
            if(grid[j1][0]== 1) dfs(j1, 0, visited, dc, dr, grid, m, n);
            if(grid[j1][n-1]== 1) dfs(j1, n-1, visited, dc, dr, grid, m, n);
        }
        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(visited[i][j] == false && grid[i][j]== 1) count++;
            }
        }
        return count;

    }

    public void dfs(int r , int c, boolean[][] visited, int[]dc, int[] dr, int[][] grid, int m, int n){
        visited[r][c] = true;
        for(int i =0; i< 4; i++){
            int newI = r + dr[i];
            int newJ = c + dc[i];
            if(isSafe(newI, newJ, m, n) && visited[newI][newJ]==false && grid[newI][newJ] == 1){
                dfs(newI, newJ, visited, dc, dr, grid, m, n);
            }
        }
    }
    public static boolean isSafe(int i, int j ,int m, int n){
        return i>0 && i<m-1 && j>0 && j<n-1;
    }
}
