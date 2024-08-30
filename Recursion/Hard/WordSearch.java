package DSA.Recursion.Hard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if(checkForWord(board, i, j, m, n, visited, 0, word)) return true;
                }
            }
        }
        return false;
    }
    public boolean checkForWord(char[][] board, int i, int j ,
                                int maxRow, int maxCol, boolean[][] visited,int wordIndex, String word){
       if(wordIndex == word.length()) return true;
       else if(i<0 || i == maxRow || j<0 || j== maxCol || visited[i][j]) return false;
       else if(board[i][j] == word.charAt(wordIndex)){
           visited[i][j] = true;
           if(checkForWord(board, i+1, j, maxRow, maxCol, visited, wordIndex+1, word)
                   || checkForWord(board, i-1, j, maxRow, maxCol, visited, wordIndex+1, word)
           || checkForWord(board, i, j+1, maxRow, maxCol, visited, wordIndex+1, word)
           || checkForWord(board, i, j-1, maxRow, maxCol, visited, wordIndex+1, word)) return true;
           else visited[i][j] = false;
       } return false;
    }
}
