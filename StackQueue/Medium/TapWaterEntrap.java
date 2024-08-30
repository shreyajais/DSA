package DSA.StackQueue.Medium;

import java.util.Stack;

public class TapWaterEntrap {
    public int trap(int[] height) {
        int n = height.length;
        int[] greatestLeft = new int[n];
        greatestLeft[0] = height[0];
        int[] greatestRight = new int[n];
        greatestRight[n-1] = height[n-1];
        for(int i =0; i<n; i++){
            greatestLeft[i] = Math.max(greatestLeft[i-1], height[i]);
        }
        for(int i = n-1; i>=0; i--){
            greatestRight[i] = Math.max(greatestRight[i+1], height[i]);
        }
        int totalWater = 0;
        for(int i =1; i<n-1; i++){
            int maxHt = Math.min(greatestRight[i], greatestLeft[i]);
            totalWater+= maxHt - height[i];
        }
        return totalWater;
    }




}
