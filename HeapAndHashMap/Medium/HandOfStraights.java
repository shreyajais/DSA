package DSA.HeapAndHashMap.Medium;

import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i =0; i<hand.length; i++) mp.put(hand[i], mp.getOrDefault(hand[i], 0)+1);
        for(int i = 0; i<hand.length; i++){
            if(mp.containsKey(hand[i]-1)) continue;
            else {

            }
        }
    }
}
