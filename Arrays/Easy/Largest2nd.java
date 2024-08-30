package DSA.Arrays.Easy;

import java.util.List;

public class Largest2nd {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int max2 = Integer.MAX_VALUE, max = arr.get(0);
        for(int i =1; i<arr.size(); i++){
            if(arr.get(i) > max){
                max2 = max;
                max = arr.get(i);
            } else if(arr.get(i)> max2 && arr.get(i) < max){ // 2nd condition
                max2 = arr.get(i);
            }
        }
        return max2;
    }
}
