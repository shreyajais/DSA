package DSA.Strings.Medium;

public class HappyPrefix {
    public String longestPrefix(String s) {
        int start1 = 0, end1 = s.length()-2, i = start1;
        int start2 = 1, end2 = s.length()-1, j = end2;
        if(s.charAt(i) != s.charAt(j)) return "";
        while(i<end1 && j>start2){
            if(s.charAt(i) != s.charAt(j)) return s.substring(start1, i+1);
                i++; j--;
        }
        return "";
    }
}
