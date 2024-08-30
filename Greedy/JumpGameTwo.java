package DSA.Greedy;

public class JumpGameTwo {
    public int jump(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0, jumpsSoFar = 0;
        for(int i =0; i<n; i++){
            min = i+1; max = nums[i] + i;
            jumpsSoFar++;
        }


    }

}
