package DSA.Arrays.Medium;

import java.util.Arrays;

public class LargestArraySumZero {
    int maxLen(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        int sumSoFar = 0;
        int start = 0, end = n-1;
        while(start<=end){
            if(arr[end] == 0 && max < 1 ) max = 1;
        }
    }
}
