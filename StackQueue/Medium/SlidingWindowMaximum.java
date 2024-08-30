package DSA.StackQueue.Medium;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int i = 0;
        int max = Integer.MAX_VALUE;
        int maxIndex =
        while(dq.size()<=k){
            max
            dq.push(i);
            i++;
        }
        for(int i =0; i<n; i++){
            int max = Integer.MAX_VALUE;
            while(dq.size()<k)
        }
    }
}
