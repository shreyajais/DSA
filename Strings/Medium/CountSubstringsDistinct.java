package DSA.Strings.Medium;

import java.util.ArrayList;

public class CountSubstringsDistinct {
    long count;
    long substrCount (String S, int K) {
        count = 0;
        substrCountRecur(0, new ArrayList<>(), "", S, K, S.length());
        return count;
    }
    private void substrCountRecur(int index, ArrayList<Character> strSoFar, String str, String s, int K, int strLen){
        if(index== strLen){
            if(strSoFar.size() == K) count++;
            return;
        }
        if(strSoFar.size()>K) return;
        char ch = s.charAt(index);
        if(strSoFar.contains(ch)){
            substrCountRecur(index+1, strSoFar, str+ ch, s, K, strLen);
            substrCountRecur(index+1, strSoFar, str, s, K, strLen);
        } else {
            strSoFar.add(ch);
            substrCountRecur(index+1, strSoFar, str+ ch, s, K, strLen);
            strSoFar.remove(strSoFar.size()-1);
            substrCountRecur(index+1, strSoFar, str, s, K, strLen);
        }
    }
}
