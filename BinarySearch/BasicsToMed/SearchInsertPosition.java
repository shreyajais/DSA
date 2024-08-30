package DSA.BinarySearch.BasicsToMed;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (high+low)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        // high will be smaller than target and high will be higher.
        return low;
    }
}
