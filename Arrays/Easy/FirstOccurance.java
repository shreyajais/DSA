package DSA.Arrays.Easy;

public class FirstOccurance {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        if(haystack.length() == needle.length()) return haystack.equals(needle) ? 0: -1;
        int len = needle.length();
        for(int i = 0; i<haystack.length(); i++){
            if(haystack.charAt(i)== needle.charAt(0)){
                if(haystack.substring(i, i+len).equals(needle)) return i;
            }
        }
        return -1;
    }
}
