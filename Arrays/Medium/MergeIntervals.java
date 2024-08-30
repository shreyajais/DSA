package DSA.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] interval = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(interval[1] >= intervals[i][0]){
                interval[1] = (int)Math.max(interval[1], intervals[i][1]);
            } else {
                ans.add(interval);
                interval = intervals[i];
            }
        }
        ans.add(interval);
        int[][] ansArr = new int[ans.size()][2];
        for(int i =0; i<ans.size(); i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }


    // 2nd my solution:

    class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge2(int[][] intervals) {

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
        int[][] ans = getArrayFromArrayList(arr);
        return ans;
    }

    public int[][] getArrayFromArrayList(ArrayList<Pair> arr){
        int[][] ans = new int[arr.size()][2];
        int ele = 0;
        while(ele<arr.size()){
            ans[ele][0] = arr.get(ele).start;
            ans[ele][1] = arr.get(ele).end;
            ele++;
        }
        return ans;
    }

    public boolean checkForMerge(int startI, int startJ, int x , int y){
        if(x>= startI && x<=startJ) return true;
        else if(y>= startI && y<=startJ) return true;
        else return false;
    }
}
