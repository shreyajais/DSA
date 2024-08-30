package DSA.Arrays.Easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int start = 0, i = 0;
        while(i< nums.length){
            int x = nums[i];
            nums[start] = x;
            start++;
            while(i< nums.length && nums[i] == x) i++;
        }
        return start;
    }
}
