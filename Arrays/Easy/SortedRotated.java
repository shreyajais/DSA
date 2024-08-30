package DSA.Arrays.Easy;

public class SortedRotated {
    public boolean check(int[] nums) {
        int count = 0, len = nums.length;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                if(i ==0) {
                    reverseArr(nums, 0, len-1);
                }
                else {
                    reverseArr(nums, 0, i);
                    reverseArr(nums, i+1, len-1);
                    reverseArr(nums, 0, len);
                }
                return isSorted(nums);
            }
        }
        return isSorted(nums);
    }

    private void reverseArr(int[] nums, int start, int end) {
        while(start<end){
            swapNo(nums, start, end);
            start++; end--;
        }
    }

    private void swapNo(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private boolean isSorted(int[] nums) {
        for(int i =0; i<nums.length; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
}
