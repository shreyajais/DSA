package DSA.Strings.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortFreqCharacter {
    public String frequencySort(String s) {
        int max = 0;
        Map<Character, Integer> mp= new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            max = Math.max(max, mp.get(ch));
        }
        int[] arr = new int[s.length()];
        String ans = "";
        int i =0; int val = max;
        while(i<arr.length){
            mp.
        }

    }
}
