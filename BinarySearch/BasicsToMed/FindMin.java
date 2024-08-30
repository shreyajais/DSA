package DSA.BinarySearch.BasicsToMed;

public class FindMin {
    public int findMin(int[] nums) {
        // only NOT rotated nums[low] < nums[high]
        // always move towards unsorted side.
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[1] && nums[0] < nums[n-1] )  return nums[0];
        if(nums[n-1] < nums[0] && nums[n-1] < nums[n-2] )  return nums[n-1];
        // whenever any array is rotated arr[low] >= arr[high]
        int low = 1;
        int high = nums.length -2;
        while(low<=high) {
            int mid = (low + high) / 2;
            // smaller than left and right
            if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) return nums[mid];
            // if array is not rotated
            if(nums[low]< nums[high]) return nums[low];
            // if rotated then always on the not-sorted side.
            if(nums[low]<= nums[mid]) low =  mid +1;
            else high = mid-1;

        }
        return nums[high];
    }
}
