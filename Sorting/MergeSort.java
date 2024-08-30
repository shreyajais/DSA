package DSA.Sorting;

public class MergeSort {
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    void merge(int arr[], int l, int m, int r)
    {
        // Your code here
        int i =l, j = m+1;
        while(i<=m && j<= r){
            if(arr[i]> arr[j]){
                swapValues(arr, i, j);
                i++;
            }

        }
    }

    private  void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
