package DSA.Strings.Medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> romanMap = getRomanMapping();
        int i =s.length();
        int sum = 0;
        while(i>=0){
            char ch1 = s.charAt(i);
            int value1 = romanMap.get(ch1);
            if(i >0){
                char ch2 = s.charAt(i-1);
                int value2 = romanMap.get(ch2);
                if(value2 < value1){
                    int newValue = value1 - value2;
                    sum+= newValue;
                    i = i-2;
                } else {
                    sum += value1;
                    i--;
                }
            } else {
                sum += value1;
                i--;
            }
        }
        return sum;
    }
    public Map<Character,Integer> getRomanMapping(){
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        return mp;
    }
}
