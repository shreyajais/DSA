package DSA.Arrays.Sorting;

public class Bubble {
    // here also we take two elements at a time and sort where we swap to brigger at
    void bubbleSort(int arr[]){
        int n = arr.length;
        for(int end = n-1; end>=0; end--){
            for(int j = 1; j<=end; j++){
                if(arr[j] > arr[j-1]) swapValues(arr, j, j-1);
            }
        }
    }

    private void swapValues(int[] arr, int maxIndex, int i) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[i];
        arr[i] = temp;
    }
}
