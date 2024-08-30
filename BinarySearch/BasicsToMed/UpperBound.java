package DSA.BinarySearch.BasicsToMed;

import java.util.Arrays;

public class UpperBound {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int n = arr.length;
        int[] ans = new int[2];
        Arrays.sort(arr);
        if(arr[0] > x){
            ans[0] = -1;
            ans[1] = arr[0];
            return ans;
        }
        if(arr[n-1]< x){
            ans[0] = arr[n-1];
            ans[1] = -1;
            return ans;
        }
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]== x){
                ans[0] = mid == 0 ? -1 : arr[mid-1];
                ans[1] = mid == n-1 ? -1 : arr[mid+1];
                return ans;
            }
            else if(arr[mid]<x) low = mid +1;
            else high = mid-1;
        }
        ans[0] = arr[high];
        ans[1] = arr[low];
        return ans;
    }
}
