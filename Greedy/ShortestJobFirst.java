package DSA.Greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[] ) {
        Arrays.sort(bt);
        int n = bt.length;
        int timeSoFar = 0, waitingTimeSoFar = 0;
        for(int i =0; i<n; i++){
            waitingTimeSoFar += timeSoFar;
            timeSoFar += bt[i];
        }
        return (waitingTimeSoFar/n);
    }
}
