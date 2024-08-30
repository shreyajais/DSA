package DSA.Arrays.Hard;

import java.util.ArrayList;

public class ReversePair {
    public int reversePairs(int[] nums) {
        return mergeSortWithCountReversePairs(nums, 0, nums.length-1);
    }

    private int mergeSortWithCountReversePairs(int[] nums, int start, int end){
        if(start>=end) return 0;
        int count = 0;
        int mid = (start+end)/2;
        count += mergeSortWithCountReversePairs(nums, start, mid);
        count += mergeSortWithCountReversePairs(nums, mid+1, end);
        count += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }

    private int countPairs(int[] nums, int start, int mid, int end) {
        int count = 0; int j = mid+1;
        for(int i = start; i<=mid; i++){
            while(j<=end  && nums[i]>=(2*nums[j])){
                count+= (mid-i+1);
                j++;
            }
        }
        return count;
    }

    private void merge(int[] nums, int start, int mid, int end){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = start, j = mid+1;
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                ans.add(nums[i]);
                i++;
            } else {
                ans.add(nums[j]); j++;
            }
        }
        while(i<=mid){
            ans.add(nums[i]);
            i++;
        }
        while (j<=end){
            ans.add(nums[j]);
            j++;
        }
        int l = 0;
        for(int k =start; k<=end; k++){
            nums[k] = ans.get(l++);
        }
        return;
    }


}
