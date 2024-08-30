package DSA.BinarySearch.BasicsToMed;

public class FirstAndLastOccurance {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        if(n == 0){
            ans[0] =-1; ans[1] = -1; return ans;
        }
        int first = getFirstOccurance(nums, n , target);
        if(first == -1){
            ans[0] =-1; ans[1] = -1; return ans;
        }
        if(first == n-1){
            ans[0] = n-1; ans[1] = ans[0]; return ans;
        }
        int last = getLastOccurance(nums, n, first, target);
        ans[0] = first; ans[1] = last;
        return ans;
    }

    private int getLastOccurance(int[] nums, int n, int first, int target) {
        int low = first+1, high = n-1, lastSoFar = first;
        while (low<=high){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                lastSoFar = mid;
                low = mid+1;
            } else if(target<nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return lastSoFar;

    }

    private int getFirstOccurance(int[] nums, int n, int target) {
        int low = 0, high = n-1;
        int firstSoFar = -1;
        while (low<=high){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                firstSoFar = mid;
                high = mid-1;
            } else if(target<nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return firstSoFar;
    }
}
