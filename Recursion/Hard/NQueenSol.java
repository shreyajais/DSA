package DSA.Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenSol {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        dfs(0, ans, board, n);
        return ans;
    }

    private void dfs(int i, List<List<String>> ans, char[][] board, int n) {
        if(i == n){
            ans.add(construct(board));
            return;
        }
        for(int j = 0; j<n; j++){
            if(validate(board, i, j)){
                board[i][j] = 'Q';
                dfs(i+1, ans, board, n);
                board[i][j] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for(int i =0; i< board.length; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    private boolean validate(char[][] board, int i, int j) {
        int rowI = i, colI = j;
        while(rowI >=0 && colI >=0){
            if(board[rowI][colI] == 'Q') return false;
            rowI--; colI--;
        }
        rowI = i; colI = j;
        while(colI>=0){
            if(board[rowI][colI] == 'Q') return false;
            colI--;
        }
        rowI = i; colI = j;
        while(rowI >=0 && colI < board.length){
            if(board[rowI][colI] == 'Q') return false;
            rowI--; colI++;
        }
        return true;
    }
}
