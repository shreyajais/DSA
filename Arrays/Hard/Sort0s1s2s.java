package DSA.Arrays.Hard;

public class Sort0s1s2s {
    // first 0 then 2 and then move one till one<=two => while condition
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = nums.length-1;
        while (one<two){
            if(one<two && nums[one] == 0){
                if(one == zero){
                    one++; zero++;
                } else {
                    swap(nums, zero, one); zero++;
                }
            } if(one<two && nums[one] == 2){
                swap(nums, one, two);
                two--;
            }
            if(one<two && nums[one]==1) one++;
        }






        while(one<= zero && two>one){
            if(nums[one] == 0){
                if(one==zero){
                    one++; zero++;
                } else {
                    swap(nums, one, zero);
                    zero++;
                }
            }
            while(nums[one] == 1) one++;
            if(nums[one] == 2){
                swap(nums, one, two);
                two--;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
