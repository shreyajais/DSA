package DSA.Arrays.Sorting;

import java.util.ArrayList;

public class Merge {
    // raaaatttt loooo
    void merge(int arr[], int l, int m, int r)
    {
        ArrayList<Integer> sortedList = new ArrayList<>();
        int left = l, right = m+1;
        while(left<=m && right<=r){
            if(arr[left]<= arr[right]){
                sortedList.add(arr[left]);
                left++;
            } else {
                sortedList.add(arr[right]);
                right++;
            }
        }
        while(left<=m){
            sortedList.add(arr[left]);
            left++;
        }
        while(right<=r){
            sortedList.add(arr[right]);
            right++;
        }
        for(int i =l; i<=r; i++){
            arr[i] = sortedList.get(i-l);
        }
        return;
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l>=r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
        return;
    }
}
