package DSA.BinarySearch.Medium;

public class SplitArrayLargestSum {
    // same as allocation sum problem
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k>n) return -1;
        if(k==n) return getMax(nums, n); // each subarry is one index
        int low = getMax(nums, n);
        int high = getSumOfAll(nums, n);
        while(low<=high){
            int mid = (low+high)/2;
            if(canAdjustSum(nums, n, k, mid)) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private boolean canAdjustSum(int[] arr, int n, int m, int maxSum) {
        int countArrays = 0;
        int sumCapacity = maxSum;
        int i=0;
        while(i<n && countArrays<m){
            if(arr[i]>sumCapacity){
                countArrays++;
                sumCapacity = maxSum;
            }
            sumCapacity -= arr[i];
            i++;
        }
        return countArrays == m;
    }

    private int getSumOfAll(int[] arr, int n) {
        int sum = 0;
        for(int i =0; i<n; i++){
            sum += arr[i];
        }
        return sum;
    }


    private int getMax(int[] nums, int n) {
        int max = nums[0];
        for(int i =1; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
