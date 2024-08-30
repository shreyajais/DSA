package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateWithPara(n, 0, 0, "", ans);
        return ans;
    }
    public void generateWithPara(int n, int countOpen, int countClose, String strSoFar, List<String> ans){
        if(countClose== n && countOpen==n){
            ans.add(strSoFar);
            return;
        }
        if(countOpen == n){
            strSoFar = strSoFar +  ")";
            generateWithPara(n, countOpen, ++countClose, strSoFar, ans);
        } else if(countOpen == countClose){
            strSoFar = strSoFar +  "(";
            generateWithPara(n, ++countOpen, countClose, strSoFar, ans);
        } else {
            strSoFar = strSoFar +  "(";
            generateWithPara(n, ++countOpen, countClose, strSoFar, ans);
            strSoFar = strSoFar.substring(0, strSoFar.length()-1);
            strSoFar = strSoFar +  ")";
            generateWithPara(n, countOpen, ++countClose, strSoFar, ans);
        }
    }
}
