package DSA.StackQueue.Medium;

import java.util.Stack;
// 0--> n-1 1--> n-2
public class Container {
    public int maxArea(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = -1;
        int[] rightMax = new int[n];
        rightMax[n-1] = n;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i =0; i<n; i++){
            while(!st1.isEmpty() && height[st1.peek()]>=height[i]) st1.pop();
            if(st1.isEmpty()) leftMax[i] = -1;
            else if(height[st1.peek()]>=height[i]) leftMax[i] = st1.peek();
            int j = n-1-i;
            while(!st2.isEmpty() && height[st2.peek()]>=height[j]) st2.pop();
            if(st2.isEmpty()) rightMax[j] = -1;
            else if(height[st2.peek()]>=height[j]) rightMax[j] = st1.peek();
        }
        int max = 0;
        for(int i = 1; i<n-1; i++){
            int area = (rightMax[i] - leftMax[i]) *(Math.min(height[rightMax[i]], height[leftMax[i]]));
            max = Math.max(area, max);
        }
        return max;
    }
}
