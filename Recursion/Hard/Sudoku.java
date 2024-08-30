package DSA.Recursion.Hard;

public class Sudoku {
    public boolean solveSudokuRecur(char[][] board) {
        for(int r =0; r<9; r++){
            for(int c =0; c<9; c++){
                if(board[r][c] == '.'){
                    for(char i = '1'; i<= '9'; i++){ // iteration in char // char c = 9  or char ch = (char) 9 will store ascii value.
                        if(isValid(board, (char)i, r, c)){
                            board[r][c] = (char) i;
                            if(solveSudokuRecur(board)) return true;
                            else board[r][c] = '.';
                        }
                    }
                    return false; // not able to put values
                }
            }
        }
        return true; // able to put all values.
    }

    private boolean isValid(char[][] board, char val, int r, int c) {
        for(int i=0; i<9; i++){
            if(board[r][i]== val) return false;
            if(board[i][c]== val) return false;
            if(board[3*(r/3)+(i/3)][3*(c/3)+(i%3)] == val) return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if(solveSudokuRecur(board)) return;
    }
}
