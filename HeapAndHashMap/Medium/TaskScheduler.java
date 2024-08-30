package DSA.HeapAndHashMap.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    class Pair implements Comparable<Pair>{
        char letter; int freq; int nextCycleTime;

        public Pair(char letter, int freq, int nextCycleTime) {
            this.letter = letter;
            this.freq = freq;
            this.nextCycleTime = nextCycleTime;
        }

        @Override
        public int compareTo(Pair o) {
            return o.freq-this.freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charFreq = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0; i< tasks.length; i++) charFreq.put(tasks[i], charFreq.getOrDefault(tasks[i], 0)+1);
        for(Map.Entry<Character, Integer> e : charFreq.entrySet()) pq.add(new Pair(e.getKey(), e.getValue(), 0));
        int time = 0;
        while(!pq.isEmpty()){
            if(pq.peek().nextCycleTime<=time){
                Pair top = pq.remove();
                if(top.freq>1) pq.add(new Pair(top.letter, top.freq -1, top.nextCycleTime+n+1));
            }
            time++;
        }
        return time;
    }
}
