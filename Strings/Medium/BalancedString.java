package DSA.Strings.Medium;

public class BalancedString {
    public int minAddToMakeValid(String s) {
        int moves = 0;
        int open = 0;
        String strSoFar = "";
        for(int i  =0; i<s.length(); i++){
            char ch = s.charAt(i);
            strSoFar = strSoFar + s.charAt(i);
            if(ch == '(') open++;
            else if(ch == ')') open--;
            while(open<0){
                strSoFar = '(' + strSoFar;
                open++;
                moves++;
            }

        }
        return moves + open;
    }
}
