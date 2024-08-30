package DSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class NonOverLappingIntervals {
    class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Pair> arr = merge(intervals);
        return intervals.length - arr.size();
    }

    public ArrayList<Pair> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int startI = intervals[0][0], startJ = intervals[0][1];
        ArrayList<Pair> arr = new ArrayList<>();
        int i = 1;
        while(i<intervals.length){
            int x = intervals[i][0], y = intervals[i][1];
            if(checkForMerge(startI, startJ, x, y)){
                startI = Math.min(startI, x);
                startJ = Math.max(startJ, y);
            } else {
                arr.add(new Pair(startI, startJ));
                startI = x;
                startJ = y;
            }
            i++;
        }
        arr.add(new Pair(startI, startJ));
        return arr;
    }

    public boolean checkForMerge(int startI, int startJ, int x , int y){
        if(startI<=x && startJ>=y) return true;
        else if(startJ>x && startJ<=y) return true;
        else if()
        else return false;
    }
}
