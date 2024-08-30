package DSA.Graph;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static class Block{
        int r; int c; int time;
        Block(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }


    public static int orangesRotting(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0; i< m ; i++){
            Arrays.fill(visited[i], false);
        }
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};

        Queue<Block> q = new LinkedList<>();
        int countFresh = 0;
        for(int i =0; i< m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Block(i, j, 0));
                    visited[i][j] = true;
                } else if(grid[i][j] == 1) countFresh++;
            }
        }
        if(countFresh==0) return 0;

        int freshToRottenOranges = 0;
        int timer = 0;
        while(!q.isEmpty()){
            int sizeQ = q.size();
            for(int k =0; k<sizeQ; k++){
                Block node = q.peek();
                q.remove();

                for(int i =0; i< 4; i++){
                    int newI = node.r + dr[i];
                    int newJ = node.c + dc[i];
                    if(isSafe(newI, newJ, m, n) && visited[newI][newJ]== false && grid[newI][newJ] == 1){
                            Block c = new Block(newI, newJ, timer);
                            q.add(c);
                    }
                }
            }
            if(q.size()!=0) {
                freshToRottenOranges += q.size();
                timer++;
            }
        }
        return (freshToRottenOranges == countFresh) ? timer : -1;
    }


    public static boolean isSafe(int i, int j ,int m, int n){
        return i>0 && i<m-1 && j>0 && j<n-1;
    }
}