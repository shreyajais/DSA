package DSA.Arrays.Sorting;

public class Selection {
    // sub arr taken from 0 to i where i keeps on decreasing from n-1 to 1 as we keep on keeping max from subarry to last----> i.
    void selectionSort(int arr[]){
        int n = arr.length;
        for(int i = n-1; i>=1; i--){
            int maxIndex = 0;
            for(int j =1; j<=i; j++){
                if(arr[j]>arr[maxIndex]) maxIndex = i;
            }
            swapValues(arr, maxIndex, i);
        }
    }

    private void swapValues(int[] arr, int maxIndex, int i) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[i];
        arr[i] = temp;
    }
}
