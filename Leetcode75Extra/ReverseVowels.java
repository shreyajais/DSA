package DSA.Leetcode75Extra;

import java.util.ArrayList;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int start = 0, end = s.length()-1;
        ArrayList<Character> vowels = getListOfVowels();

        while(start<end){
            while(start<end && !vowels.contains(s.charAt(start))) start++;
            while(start<end && !vowels.contains(s.charAt(end))) end--;
            if(start<end){
                if(s.charAt(start)!= s.charAt(end)) swap(s, start, end);
                start++; end--;
            }
        }

    }

    private void swap(String s, int start, int end) {
        Character ch = s.charAt(start);
    }

    private ArrayList<Character> getListOfVowels() {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i' ); vowels.add('o'); vowels.add(  'u');
        return vowels;
    }
}
