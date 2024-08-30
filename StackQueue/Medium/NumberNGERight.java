package DSA.StackQueue.Medium;

import java.util.ArrayList;
import java.util.Stack;

public class NumberNGERight {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // no use of stack its just simple 2 level iteration
        int[] ans = new int[queries];
        for(int i = 0; i<queries-1; i++){
            int count = 0;
            for(int j = indices[i]+1; j<N; j++){
                if(arr[indices[i]] < arr[j]) count++;
            }
            ans[i] = count;
        }
       return ans;
    }



}
