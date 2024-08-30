package DSA.Basic.Recursion;

public class Palindrome {
    public boolean isPalindrome(String s) {
        return isPalindromeRecur(s, 0, s.length()-1);
    }
    public boolean isPalindromeRecur(String s, int start, int end){
        while(start<end && !isAlphanumeric(s, start)) start++;
        while(start<end && !isAlphanumeric(s, end)) end--;
        if(start<end && !isEqualChar(s, start, end)) return false;
        if(start == end) return true;
        else return isPalindromeRecur(s, ++start, --end);
    }

    private boolean isEqualChar(String s, int start, int end) {
        if()
    }

    public boolean isAlphanumeric(String s, int pos){
        boolean lower =  s.charAt(pos)>= 'a' && s.charAt(pos)<= 'z';
        boolean upper =  s.charAt(pos)>= 'A' && s.charAt(pos)<= 'Z';
        return lower || upper;
    }
}
