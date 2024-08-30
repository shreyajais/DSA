package DSA.BinarySearch.BasicsToMed;

import java.util.ArrayList;

public class SearchInRotated {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1) {
            if(nums[0]== target) return 0;
            else return -1;
        }
        // whenever any array is rotated arr[low] >= arr[high]
        int low = 0;
        int high = nums.length -1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[low]> nums[mid] ){ //----? right is sorted
                if(target>nums[mid] && target<=nums[high]) low = mid+1; // target lies in sorted half
                else high = mid-1;

            }  else {
                //nums[low]<= nums[mid] && nums[mid]>= nums[mid] ----left is sorted
                if(nums[low]<= target && target < nums[mid]) high = mid-1;  // target lies in sorted half
                else low = mid+1;
            }
        }
        return -1;
    }
}
