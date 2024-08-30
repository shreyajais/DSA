package DSA.BinarySearch.Medium;

public class KthMissingPositiveInteger {
    public int findKthPositive(int[] arr, int k) {
        if(k<arr[0])return k;
        int n = arr.length;
        int numberOfMissingIntTillLastIndex = numberOfMissingIntegers(arr, n-1);
        if(numberOfMissingIntTillLastIndex<k) return getMissingInteger(arr, n-1, k);
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(numberOfMissingIntegers(arr, mid)<=k) low = mid+1;
            else high = mid-1;
        }
        return getMissingInteger(arr, high, k);
    }

    private int getMissingInteger(int[] arr, int high ,int k) {
        int missingIntInd1 = numberOfMissingIntegers(arr, high);
        return (k - missingIntInd1) + arr[high];
    }

    private int numberOfMissingIntegers(int[] arr, int index) {
        return arr[index] - index -1;
    }

}
