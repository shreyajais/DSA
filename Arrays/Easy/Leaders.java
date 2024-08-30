package DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Leaders {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
        int maxSoFar = arr[n-1];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxSoFar);
        for(int i = n-2; i>=0; i--){
            if(arr[i]>= maxSoFar){
                ans.add(arr[i]);
                maxSoFar = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
