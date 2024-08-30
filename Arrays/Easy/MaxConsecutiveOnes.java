package DSA.Arrays.Easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, lenSoFar = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 1) lenSoFar++;
            else{
                if(lenSoFar > 0){
                    max = Math.max(max, lenSoFar);
                    lenSoFar = 0;
                }
            }
        }
        if(lenSoFar > 0) max = Math.max(max, lenSoFar);
        return max;
    }
}
