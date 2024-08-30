package DSA.Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxPosCanReach = 0;
        for(int i =0; i<nums.length; i++){
            if(maxPosCanReach < i) return false;
            int maxJumpAtI = nums[i] == 0 ? 0 : nums[i] + i;
            maxPosCanReach = Math.max(maxPosCanReach, maxJumpAtI);
        }
        return true;
    }
}
