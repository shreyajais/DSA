package DSA.Arrays.Easy;

import java.util.HashSet;
import java.util.Set;

public class Happy {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        int val = n;
        while(true){
            int sum = 0;
            while(val >0){
                sum += Math.pow(val%10, 2);
                val /= 10;
            }
            if(sum == 1) return true;
            else if(s.contains(sum)) return false;
            else val = sum;
        }
    }
}
