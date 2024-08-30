package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    class DistancePair{
        int i; int j; int dist;
        DistancePair(int i , int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        Queue<DistancePair> pq = new LinkedList<>();
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i =0; i< grid.length; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        pq.add(new DistancePair(0, 0, 1));
        dist[0][0] = 1;

        while(!pq.isEmpty()){
            DistancePair node = pq.poll();
            for(int dir=0; dir<8; dir++){
                int newI = node.i + dr[dir];
                int newJ = node.j + dc[dir];
                if(isValidCell(newI, newJ, grid, grid.length)){
                    if((node.dist + 1)< dist[newI][newJ]){
                        dist[newI][newJ] = node.dist + 1;
                        pq.add(new DistancePair(newI, newJ, dist[newI][newJ]));
                    }
                }
            }
        }
        return dist[grid.length-1][grid.length-1] == Integer.MAX_VALUE ? -1: dist[grid.length-1][grid.length-1];
    }

    private boolean isValidCell(int newI, int newJ, int[][] grid, int length) {
        return newI>=0 && newI<length && newJ>=0 && newJ<length && grid[newI][newJ]==0;
    }
}
