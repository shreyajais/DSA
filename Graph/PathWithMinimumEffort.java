package DSA.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    class DistancePair{
        int i; int j; int heightSoFar;
        DistancePair(int i, int j, int dist){
            this.i=i;
            this.j =j;
            this.heightSoFar = dist;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int[][] distance = new int[heights.length][heights.length];
        for(int i =0; i< heights.length; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        PriorityQueue<DistancePair> pq = new PriorityQueue<>((a,b)-> a.heightSoFar-b.heightSoFar);

        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};

        pq.add(new DistancePair(0, 0, 0));
        distance[0][0]=0;

        while(!pq.isEmpty()){
            DistancePair p = pq.poll();
            for(int dir =0; dir<4; dir++){
                int newI = p.i + dr[dir];
                int newJ = p.j + dc[dir];
                if(isValidCell(newI, newJ, heights.length)){
                    if((heights[newI][newJ]- heights[p.i][p.j] + p.heightSoFar)<distance[newI][newJ]){
                        distance[newI][newJ] = heights[newI][newJ]- heights[p.i][p.j] + p.heightSoFar;
                        if((newI == heights.length - 1) && (newJ == heights.length-1) )return distance[newI][newJ];
                        pq.add(new DistancePair(newI, newJ, distance[newI][newJ]));
                    }
                }
            }
        }
        return distance[heights.length-1][heights.length-1];
    }

    private boolean isValidCell(int newI, int newJ, int length) {
        return newI>=0 && newI<length && newJ>=0 && newJ<length;
    }
}