package DSA.Arrays.Easy;

public class Duplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;// len is 5
        int xor1 = 0, xor2 = 0;
        for(int i =1; i<len; i++) xor1 ^= i;
        for(int i=0; i<len; i++) xor2 ^= nums[i];
        return xor1/xor2;
    }
}
