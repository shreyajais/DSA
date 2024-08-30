package DSA.Recursion.Medium;

import java.util.Arrays;

public class PerfectSum {
    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        if(sum==0) return n;
        Arrays.sort(arr);
        return countSum(0, 0, sum, arr, n, (int)Math.pow(10,9)+7);

    }

    public int countSum(int index, int sumSoFar, int sum, int arr[], int n, int mod){
        if(sumSoFar==sum) return 1;
        if(index==n) return 0;
        if(arr[index] <= (sum-sumSoFar)){
            return countSum(index+1, sumSoFar+ arr[index], sum, arr, n, mod)%mod +
                    countSum(index+1, sumSoFar, sum, arr, n, mod)%mod;
        }
        else return countSum(index+1, sumSoFar, sum, arr, n, mod)%mod;
    }
}
