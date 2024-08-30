package DSA.BinarySearch.TwoD;

public class Rowmax1s {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
       int low = 1; // min 1
       int high = m; // max 1
       while(low<=high){
           int mid = (low+high)/2;
           if(anyRowHas(arr, n, m, mid)) low = mid+1;
           else high = mid -1;
       }
       return getRowWith1(arr, n, m, high);
    }

    private int getRowWith1(int[][] arr, int n, int m, int numberOfOne) {
        for(int i = 0; i<n; i++){
            if(arr[i][m-numberOfOne] == 1) return i;
        }
        return -1;
    }

    private boolean anyRowHas(int[][] arr, int n, int m, int numberOfOne) {
        for(int i = 0; i<n; i++){
            if(arr[i][m-numberOfOne] == 1) return true;
        }
        return false;
    }
}
