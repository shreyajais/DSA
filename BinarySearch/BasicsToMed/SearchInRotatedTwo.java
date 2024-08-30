package DSA.BinarySearch.BasicsToMed;

public class SearchInRotatedTwo {
    // non distinct values
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        if(nums.length == 1) return nums[0]== target;
        // whenever any array is rotated arr[low] >= arr[high]
        int low = 0;
        int high = nums.length -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++; high--; continue;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]) high = mid-1; // sorted left half
                else low = mid+1; // sorted half
            } else {
                if(nums[high]<=target && target<nums[mid]) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}
