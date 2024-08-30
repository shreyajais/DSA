package DSA.Graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 && n == 0) return 0;
        boolean[][] visited = new boolean[m][n];
        int count  = 0;
        int[] dr = {0, -1, 0, 1}; int[] dc = {-1, 0, 1, 0};
        for(int i =0;i<m ; i++) {
            for(int j =0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    path(grid, i, j, visited, dr, dc, m, n);
                }
            }
        }
        return count;
    }

    private void path(char[][] grid, int i, int j, boolean[][] visited, int[] dr, int[] dc, int m ,int n) {
        visited[i][j]= true;
        for(int k =0; k<4; k++){
            int newI = i+dr[k];
            int newJ = j + dc[k];
            if(newI>=0 && newI<m && newJ>=0 && newJ<n && !visited[newI][newJ] && grid[newI][newJ] == '1'){
                path(grid, newI, newJ, visited, dr, dc, m, n);
            }
        }
    }
}
