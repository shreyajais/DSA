package DSA.HeapAndHashMap.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqEle {
    class Pair{
        int val; int freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i =0; i<n; i++) mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq-b.freq); // min heap smallest on top
        for(Map.Entry<Integer, Integer> e: mp.entrySet()){
            if(pq.isEmpty() || pq.peek().freq < e.getValue()) pq.add(new Pair(e.getKey(), e.getValue()));
            if(pq.size()>k) pq.remove();
        }
        int[] ans = new int[k];
        int index = 0;
        while(pq.isEmpty()) ans[index++] = pq.remove().val;
        return ans;
    }
}
