package DSA.Strings.Medium;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String longest = "";
        longestPalindromeRecur(s, longest, 0);
        return longest;
    }

    public void longestPalindromeRecur(String s, String longest, int start){
        if(s.length()== start) return;
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i) && longest.length() < (i-start+1)){
                longest = s.substring(start, i+1);
            }
            longestPalindromeRecur(s, longest, i);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) return true;
        int i = start, j = end;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

}
