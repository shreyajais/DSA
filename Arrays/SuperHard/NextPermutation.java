package DSA.Arrays.SuperHard;

public class NextPermutation {
    // 1. find the breakpoint where len -1 to 0 where arr[i]<arr[i-1]
    // 2. find just next bigger than arr[i] and swap with i.
    // 3. after swapping it will still stay in decresing  order
    // 4. reverse from index+1 to length.
    public void nextPermutation(int[] nums) {
        int index = findThePeekPoint(nums);
        if(index == -1){
            reverseArray(nums, 0, nums.length-1);
            return;
        }
        int nextGreaterIndex = findNextGreater(nums, index);
        swap(nums, index, nextGreaterIndex);
        reverseArray(nums, index+1, nums.length-1);
        return;
    }

    public int findThePeekPoint(int[] nums){
        for(int i= nums.length-2; i>=0; i++){
            if(nums[i]< nums[i+1]) return i;
        }
        return -1;
    }
    public int findNextGreater(int[] nums, int index){
        int val = nums[index];
        for(int i = nums.length-1; i>index; i--){
            if(nums[i] > nums[index]) return i;
        }
        return nums.length-1;
    }
    private void reverseArray(int[] nums, int start, int end) {
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }
}
