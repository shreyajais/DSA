package DSA.Strings.Medium;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        String strSoFar = "";
        int start = -1;
        int open = 0;
       for(int i =0; i<s.length(); i++){
           char ch = s.charAt(i);
           if(ch == '('){
               open++;
               if(start == -1) start = i;
           }else if(ch == ')'){
               open--;
               if(open == 0){
                   strSoFar = removeBrackets(s, strSoFar, start, i);
                   start = -1;
               }
           }
       }
       return strSoFar;
    }

    private String removeBrackets(String s, String strSoFar, int startIndex, int endIndex) {
        return strSoFar + s.substring(startIndex+1, endIndex);
    }
}
