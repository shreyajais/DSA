package DSA.Strings.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int count1 = 0;
        for(int i =0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(arr[index] == -1){
                arr[index] = 0;
                count1++; // count distinct anagrams
            }
        }
        int count2 = 0;
        for(int i =0; i<t.length(); i++){
            int index = s.charAt(i) - 'a';
            if(arr[index] == -1)  return false;
            else if(arr[index] == 1) continue;
            else {
                count2++;
                arr[index] = 1;
            }
        }
        return count1 == count2;
    }
}
