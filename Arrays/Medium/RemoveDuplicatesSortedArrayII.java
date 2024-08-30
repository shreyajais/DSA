package DSA.Arrays.Medium;

public class RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int val = nums[0], count = 1;
        for(int i =1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
               if(count == 1){
                   nums[index++] = nums[i];
               } else continue;
            } else {
                val = nums[i]; count = 1;
                nums[index++] = val;
            }
        }
        return index;
    }
}
