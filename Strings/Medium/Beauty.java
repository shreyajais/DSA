package DSA.Strings.Medium;

import java.util.HashMap;
import java.util.Map;

public class Beauty {
    public int beautySum(String s) {
        int min = Integer.MAX_VALUE, max = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            max = Math.max(mp.get(ch), max);
            min = Math.min(mp.get(ch), min);
        }

    }
}
