package DSA.Arrays.Medium;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i< nums.length; i++){
            xor = xor ^ nums[i];
            xor = xor ^i;
        }
        xor = xor^ (nums.length);
        return xor;

    }
}
