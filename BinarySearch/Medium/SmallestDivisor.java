package DSA.BinarySearch.Medium;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = getMaxDivisor(nums);
        while(low<=high){
            int mid = low + (high-low)/2;
            int divisorSum = getDivisorSum(nums, mid);
            if(divisorSum<=threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private int getMaxDivisor(int[] nums) {
        int max = nums[0];
        for(int i =1; i< nums.length; i++) max = Math.max(max, nums[i]);
        return max;
    }

    private int getDivisorSum(int[] nums, int divisor){
        int sum = 0;
        for(int i =0; i< nums.length; i++){
            if(nums[i]%divisor == 0) sum += nums[i]/divisor;
            else sum += nums[i]/divisor +1 ;
        }
        return sum;
    }
}
