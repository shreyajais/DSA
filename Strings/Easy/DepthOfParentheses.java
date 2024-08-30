package DSA.Strings.Easy;

public class DepthOfParentheses {
    public int maxDepth(String s) {
        int countOpen = 0,max  = 0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                countOpen++;
                max = Math.max(countOpen, max);
            } else if(ch == ')') countOpen--;
        }
        return max;
    }
}
