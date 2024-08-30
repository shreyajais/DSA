package DSA.Arrays.Sorting;

public class Insertion {
    // sub arr taken from 0 to i where i keeps on decreasing from n-1 to 1 as we keep on keeping max from subarry to last----> i.
    void insertionSort(int arr[]){
        for(int i= 1; i<arr.length; i++){
            if(arr[i]> arr[i-1]) continue;
            else {
                int pos = getInsertPosition(i, arr);
                shiftArraySoFar(arr, pos, i);
            }
        }
        return;
    }

    private void shiftArraySoFar(int[] arr, int pos, int ind) {
        for(int i = ind-1; i>=pos; i--){
            arr[i+1] = arr[i];
        }
        arr[pos] = arr[ind];
        return;
    }

    private int getInsertPosition(int i, int[] arr) {
        if(arr[0]> arr[i]) return 0;
        for(int pos = i-1; pos>0; pos--){
            if(arr[i]<arr[pos] && arr[i]>= arr[pos-1]) return pos;
        }
        return -1;
    }


}
