package DSA.Arrays.Medium;

public class MoveZeroes {
    // snowball technique
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] != 0){
                if (nonZero != i) {
                    nums[nonZero] = nums[i];
                }
                nonZero++;
            }
        }
        // fill zero
        for(int z = nonZero; z< nums.length; z++){
            nums[z] = 0;
        }
    }




    /// my attempt partially correct
    public void moveZeroes2(int[] nums) {
        int startZero = 0, nonZero = 0;
        while(startZero< nums.length && nonZero< nums.length){
            while(startZero< nums.length && nums[startZero]!= 0) startZero++;
            while(nonZero< nums.length && nums[nonZero] == 0) nonZero++;
            if(startZero< nums.length && nonZero< nums.length && startZero < nonZero) swapNos(nums, startZero, nonZero);
        }
    }

    private void swapNos(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
