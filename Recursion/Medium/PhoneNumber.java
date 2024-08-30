package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> mp = getStringForDigit();
        List<String> ans = new ArrayList<>();

        // add the Corresponding strings
        ArrayList<String> arr = new ArrayList<>();
        for(int i =0; i<digits.length(); i++) arr.add(mp.get(digits.charAt(i)));
        
        // recursion
        getLetterCombinations(0, "", arr, arr.size(), ans);
        return ans;

    }

    private void getLetterCombinations(int index, String strSoFar, ArrayList<String> arr, int len, List<String> ans) {
        if(index == len){
            if(strSoFar.length() > 0)ans.add(strSoFar);
            return;
        }
        for(int i = 0; i< arr.get(index).length(); i++){
            strSoFar = strSoFar + arr.get(index).charAt(i);
            getLetterCombinations(index+1, strSoFar, arr, len, ans);
            strSoFar = strSoFar.substring(0, strSoFar.length()-1);
        }
    }

    public Map<Character, String> getStringForDigit(){
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        return mp;
    }
}
