package DSA.Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(mat[0][0] == 0) return ans;
        int maxRow = mat.length;
        int maxCol = mat[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        char[] ch = {'L', 'U', 'R', 'D'};
        findPathRecur(0, 0, dr, dc, ch, "", visited, maxRow, maxCol, mat, ans);
        return ans;
    }

    private void findPathRecur(int i, int j,int[] dr, int[] dc, char[] ch, String strSoFar, boolean[][] visited, int maxRow, int maxCol, int[][] mat, ArrayList<String> ans) {
        if(i== maxRow-1 && j== maxCol-1){
            ans.add(strSoFar);
            return;
        }
        visited[i][j] = true;
        for(int k =0; k< 4; k++){
            int newI = i + dr[k], newJ = j + dc[k];
            if(newI >=0 && newI<maxRow && newJ>=0 && newJ<maxCol && mat[newI][newJ] == 1 && !visited[newI][newJ] ){
                findPathRecur(newI, newJ, dr, dc, ch, strSoFar + ch[k], visited, maxRow, maxCol, mat, ans);
            }
        }
        visited[i][j] = false; // here very very important plus doubts
    }
}
