package DSA.Greedy;

public class ValidParenthesis {
    public boolean checkValidString(String s) {
        int max = 0, min = 0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                max++; min++;
            } else if(ch == ')'){
                max--; min --;
            } else {
                int minMin = min-1, minMax = min+1, minZero = min;
                int maxMin = max-1, maxMax = max+1, maxZero = max;
                max = maxMax;
                min = Math.max()
            }
        }
    }
}
