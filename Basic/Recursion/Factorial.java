package DSA.Basic.Recursion;

import java.util.ArrayList;

public class Factorial {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        factorialNumbersRecur(n, 2, 1, ans);
        return ans;
    }
    static void factorialNumbersRecur(long n, long no, long val, ArrayList<Long> ans){
        if(val > n) return;
        ans.add(val);
        factorialNumbersRecur(n, no+1, val* no, ans);
    }
}
