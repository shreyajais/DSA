package DSA.Arrays.Easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n= digits.length;
        int carry= 1, i = n-1;
        while(i>=0 && carry !=0){
            if(digits[i]<9){
                digits[i] += 1;
                carry =0;
                return digits;
            } else {
                digits[i] = 0;
                i--;
            }
        }
        int[] newAns = new int[n+1];
        int index = 0;
        newAns[index++] = 1;
        for(int digit: digits) newAns[index++] = digits[digit];
        return newAns;
    }
}
