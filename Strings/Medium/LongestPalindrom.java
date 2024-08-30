package DSA.Strings.Medium;

public class LongestPalindrom {
        private int lo, maxLen;

        public String longestPalindrome(String s) {

            for (int i = 0; i < len-1; i++) {
                extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i+1); //assume even length.
            }
            return s.substring(lo, lo + maxLen);
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (maxLen < k - j - 1) {
                lo = j + 1;
                maxLen = k - j - 1;
            }
        }
}
