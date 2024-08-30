package DSA.Graph;

import java.util.ArrayList;

public class SurroundedRegions {
    public char[][] getSurroundedRegions(char[][] chessBoard ){
        int m = chessBoard.length;
        int n = chessBoard[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dc = {-1, 0, 1, 0};
        int[] dr ={0, -1, 0, 1};
        for(int i1 =0; i1<n; i1++){
            if(chessBoard[0][i1]== '0') dfs(0, i1, visited, dc, dr, chessBoard, m, n);
            if(chessBoard[0][m-1]== '0') dfs(m-1, i1, visited, dc, dr, chessBoard, m, n);
        }
        for(int j1 =0; j1<m; j1++){
            if(chessBoard[j1][0]== '0') dfs(j1, 0, visited, dc, dr, chessBoard, m, n);
            if(chessBoard[j1][n-1]== '0') dfs(j1, n-1, visited, dc, dr, chessBoard, m, n);
        }
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(visited[i][j] && chessBoard[i][j]== '0') continue;
                else chessBoard[i][j] = 'X';
            }
        }
        return chessBoard;
    }

    public void dfs(int r , int c, boolean[][] visited, int[]dc, int[] dr, char[][] chessBoard, int m, int n){
        visited[r][c] = true;
        for(int i =0; i< 4; i++){
            int newI = r + dr[i];
            int newJ = c + dc[i];
            if(isSafe(newI, newJ, m, n) && visited[newI][newJ]==false && chessBoard[newI][newJ] == '0'){
                dfs(newI, newJ, visited, dc, dr, chessBoard, m, n);
            }
        }
    }
    public static boolean isSafe(int i, int j ,int m, int n){
        return i>0 && i<m-1 && j>0 && j<n-1;
    }
}
