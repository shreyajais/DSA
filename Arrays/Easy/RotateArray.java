package DSA.Arrays.Easy;

public class RotateArray {
    public void rotateLeft(int[] nums, int k) {
        // rotate left
        reverseArr(nums, 0, k-1);
        reverseArr(nums, k, nums.length-1);
        reverseArr(nums, 0, nums.length-1);
    }

    public void rotateRight(int[] nums, int k) {
        reverseArr(nums, 0, nums.length-1);
        reverseArr(nums, 0, k-1);
        reverseArr(nums, k, nums.length-1);
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
}
