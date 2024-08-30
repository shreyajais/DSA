package DSA.Recursion.Easy;

public class AtoiTwo {
    public int myAtoi(String s) {
        String strSoFar = "";
        int sign = 1, start = 0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(start == 0){
                if(ch == ' ') continue;
                else if(ch == '+') continue;
                else if(ch == '-') sign = -1;
                else if(ch>='0' && ch<='9'){
                    strSoFar += ch;
                    start = 1;
                }
                else break;
            } else {
                if(ch>='0' && ch<='9') strSoFar += ch;
                else break;
            }
        }
        if(strSoFar.length() == 0) return 0;
        else {
            long val = Long.parseLong(strSoFar);
            if(sign == -1) val = val*sign;
            if(val<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else if(val> Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int)val;
        }
    }
}
