package DSA.Sorting;

public class SelectionSort {
    public static void main(String args[]) {

        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);
    }

    private static void selection_sort(int[] arr, int n) {
        for(int i = 0; i<n-1; i++){
            int min = i;
            for(int j = i+1; j<n; j++){
                if(arr[i]> arr[j]){
                   min = j;
                }
            }
            swapValues(arr, i, min);
        }
        return;
    }

    private static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
