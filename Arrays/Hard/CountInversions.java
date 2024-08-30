package DSA.Arrays.Hard;

import java.util.ArrayList;

public class CountInversions {

     public int inversionCount(int arr[], int n) {
         return mergeSortWithCountReversePairs(arr, 0, arr.length-1);
    }

    private int countPairs(int[] nums, int start, int mid, int end) {
        int count = 0; int j = mid+1;
        for(int i = start; i<=mid; i++){
            while(j<=end  && nums[i]>(2L*nums[j])){ // count normal inversion make this line nums[i]> nums[j]
                //  nums[i] > 2 * nums[j] ----> overflow condition and false comaprison
                count+= (mid-i+1);
                j++;
            }
        }
        return count;

        /*
        *
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        */
    }






    // copy of mergeSort function in normal merge sort expect a count function
    private int mergeSortWithCountReversePairs(int[] nums, int start, int end){
        if(start>=end) return 0;
        int count = 0;
        int mid = (start+end)/2;
        count += mergeSortWithCountReversePairs(nums, start, mid);
        count += mergeSortWithCountReversePairs(nums, mid+1, end); // we take count from both left and right subtree
        count += countPairs(nums, start, mid, end); // this is extra function call to count the inversions
        merge(nums, start, mid, end);
        return count;
    }

    // copy of merge in mergeSort.
    private void merge(int[] nums, int start, int mid, int end){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = start, j = mid+1;
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                ans.add(nums[i]);
                i++;
            } else {
                ans.add(nums[j]); j++;
            }
        }
        while(i<=mid){
            ans.add(nums[i]);
            i++;
        }
        while (j<=end){
            ans.add(nums[j]);
            j++;
        }
        int l = 0;
        for(int k =start; k<=end; k++){
            nums[k] = ans.get(l++);
        }
        return;
    }

}
//Extra explain: When nums[j] = 2147483647, 2 * nums[j] would theoretically be 4294967294,
// but this overflows in Java and wraps around to a negative value due to the limitations of the int type.
// This causes the comparison to fail or produce incorrect results.
