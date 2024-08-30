package DSA.Arrays.Easy;

public class Palindrome {

    // my solution falling in 1 test case
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0, end = s.length();
        while(start<end){
            char startCh = s.charAt(start); char endChar = s.charAt(end);
            while(start< end && !Character.isLetterOrDigit(startCh)) start++;
            while(start< end && !Character.isLetterOrDigit(endChar)) end--;
            if(start<end && !isSame(s, startCh, endChar)) return false;
            else {
                start++; end--;
            }
        }
        return true;
    }

    private boolean isSame(String s, char start, char end) {
        return Character.toLowerCase(start) == Character.toLowerCase(end);
    }
}
