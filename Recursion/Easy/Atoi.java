package DSA.Recursion.Easy;

public class Atoi {
    public int myAtoi(String s){
        if(s.length()==0) return 0;
        int sign = 1;
        String st1 = removeWhiteSpaces(s);
        if(st1.charAt(0) == '-') {
            sign = -1;
            st1 = st1.substring(1);
        }
        String st2 = removeZerosBegining(st1);
        String st3 = getUntilNonString(st2, 0, "");
        return st3.length()>0 ? formate(st3, sign) : 0;
    }

    private int formate(String st3, int sign) {
        if(Double.parseDouble(st3)<= (double) Integer.MAX_VALUE
                && Double.parseDouble(st3) >= (double) Integer.MIN_VALUE)
            return sign * Integer.parseInt(st3);
        else if(sign<0) return Integer.MIN_VALUE;
        else return Integer.MAX_VALUE;
    }

    private String getUntilNonString(String st2, int index, String strSoFar) {
        if(index == st2.length()) return strSoFar;
        if((st2.charAt(index)-'0') >= 0 && (st2.charAt(index)-'0') <=9) {
            strSoFar += Character.toString(st2.charAt(index));
            return getUntilNonString(st2, index+1, strSoFar);
        } else return strSoFar;
    }

    private String removeZerosBegining(String s) {
        if(s.charAt(0)== '0') return removeWhiteSpaces(s.substring(1));
        else return s;
    }

    private String removeWhiteSpaces(String s) {
        if(s.charAt(0)== ' ') return removeWhiteSpaces(s.substring(1));
        else return s;
    }


    // the editorial
    public int myAtoi2(String s) {
        int i =0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0'; // character is automatically converted into digit.
            // when ans is already big
            if(ans > max/10) return (sign == 1) ? max: min;
/* easier to understand and can be stored in int.
if (count > (Integer.MAX_VALUE - n) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } **/

            else if (ans == max/10 && digit > max%10) return (sign == 1) ? max: min;
            ans = ans*10 + digit;
            i++;
        }
    }
}
