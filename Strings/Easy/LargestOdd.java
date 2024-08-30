package DSA.Strings.Easy;

public class LargestOdd {
    public String largestOddNumber(String num) {
        for(int i =num.length()-1; i>=0; i--){
            int val = (int)(num.charAt(i) - '0');
            if(val%2 == 0) continue;
            return num.substring(0, i+1);
        }
        return "";
    }
}
