package DSA.DynamicPrograming.LIS;

import java.util.ArrayList;

public class LLCBinarySearch {
    static int longestSubsequence(int n, int a[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a[0]);
        for(int i =1; i<a.length; i++){
            if(a[i]> arr.get(arr.size()-1)) arr.add(a[i]);
            else {
                int j = arr.size()-1;
                while(arr.get(j)>a[i]){
                    j--;
                }
                arr.set(j+1, a[i]);
            }
        }
        return arr.size();
    }
}
