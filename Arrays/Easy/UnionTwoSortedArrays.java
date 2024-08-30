package DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionTwoSortedArrays {
    // @Important
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int start1 = 0, start2 = 0;
        while(start1 < arr1.length && start2 < arr2.length){
            int x = arr1[start1], y = arr2[start2];
            if(x == y){
                ans.add(x);
                while(start1 < arr1.length && x == arr1[start1]) start1++;
                while(start2< arr2.length && y == arr2[start2]) start2++;
            } else if(x<y){
                ans.add(x);
                while(start1 < arr1.length && x == arr1[start1]) start1++;
            }else{
                ans.add(y);
                while(start2< arr2.length && y == arr2[start2]) start2++;
            }
        }
        while(start1 < arr1.length){
            int x = arr1[start1];
            ans.add(arr1[start1]);
           while(start1 < arr1.length && x == arr1[start1]) start1++;
        }
        while(start2< arr2.length){
            int y = arr2[start2];
            ans.add(y);
            while( start2< arr2.length && y == arr2[start2]) start2++;
        }
        return ans;
    }
}
