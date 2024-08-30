package DSA.HeapAndHashMap.Medium;

import java.util.PriorityQueue;

public class KthLargestElement {
    PriorityQueue<Integer> pq;
    int[] nums;
    int k;
    public KthLargestElement(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.nums = nums;
        this.k = k;
        for(int i = 0; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.remove();
        }
    }

    public int add(int val) {
        if(pq.peek()>=val) return pq.peek();
        else {
            pq.add(val);
            pq.remove();
            return pq.peek();
        }
    }
}
