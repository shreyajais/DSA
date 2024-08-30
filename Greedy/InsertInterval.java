package DSA.Greedy;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        if(newInterval[1]< intervals[0][0]) {
            ans.add(newInterval);
            addRemaining(ans, 0, intervals, n);
            return construct(ans);
        }
        if(newInterval[0]> intervals[n-1][1]){
            addRemaining(ans, 0, intervals, n);
            ans.add(newInterval);
            return construct(ans);
        }
        for(int i =0; i<intervals.length; i++){
            if(intervals[i][1]<newInterval[0]){
                ans.add(intervals[i]); continue;
            }
            if(isMerging(intervals[i], newInterval)){
                int[] mergedInterval = new int[2];
                mergedInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                mergedInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                ans.add(mergedInterval);
                addRemaining(ans, i+1, intervals, n);
                return construct(ans);
            }
            ans.add(newInterval);
            addRemaining(ans, i, intervals, n);
            return construct(ans);
        }
        return construct(ans);
    }

    private int[][] construct(ArrayList<int[]> ans) {
        int[][] ansArray = new int[ans.size()][2];
        for(int i =0; i<ans.size(); i++){
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    private void addRemaining(ArrayList<int[]> ans, int index, int[][] intervals, int len) {
        for(int i=index; i<len; i++) ans.add(intervals[index]);
    }
    private void addRemainingWithMerge(ArrayList<int[]> ans, int index, int[][] intervals, int len) {
        int max
        for(int i=index; i<len; i++) ans.add(intervals[index]);
    }
    private boolean isMerging(int[] interval, int [] intervalToMerge){
        if(interval[1]>=intervalToMerge[0] && interval[1]<=intervalToMerge[1]) return true;
        if(interval[0]>=intervalToMerge[0] && interval[0]<=intervalToMerge[1]) return true;
        return false;
    }
}
