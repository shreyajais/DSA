package DSA.Arrays.Easy;

public class LargestElement {
    public static int largest(int n, int[] arr) {
        // code here
        int max = arr[0];
        for(int i =1; i<n; i++){
            if(max< arr[i]) max = arr[i];
        }
        return max;
    }
}
