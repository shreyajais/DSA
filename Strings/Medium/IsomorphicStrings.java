package DSA.Strings.Medium;

import java.util.Arrays;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        return iso(s, t) && iso(t, s);
    }
    public boolean iso(String s, String t){
        char[] charArr = new char[256];
        Arrays.fill(charArr, '*');
        for(int i =0; i<s.length(); i++){
            int ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(charArr[ch1] == '*'){
                charArr[ch1] = ch2;
            }else {
                if(charArr[ch1] != ch2) return false;
            }
        }
        return true;
    }
}
