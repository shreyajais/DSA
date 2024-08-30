package DSA.StackQueue.Hard;

import java.util.Stack;

public class Histogram {
    // (nextLeftSmall - nextRightSmall-1)* arr[i]
    // same itertion using stack
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] area = nextSmallestElementArea(heights, N);
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<N; i++){
            maxArea = Math.max(maxArea, area[i]);
        }
        return maxArea;
    }

    public int[] nextSmallestElementArea(int[] heights, int N){
        Stack<Integer> st = new Stack<>();
        int[] leftSmallestElement = new int[N];
        int[] rightSmallestElement = new int[N];
        rightSmallestElement[N-1] = N;
        for(int i =0; i<heights.length; i++){
            while(st.size()>0 && heights[st.peek()]> heights[i]){
               rightSmallestElement[st.peek()] = i;
               st.pop();
            }
            if(st.size()==0){
                leftSmallestElement[i] = -1;
                st.push(i);
            }
            else {
                leftSmallestElement[i] = st.peek();
                st.push(i);
            }

        }
        while(!st.isEmpty()){
            rightSmallestElement[st.peek()] = N;
            st.pop();
        }
        return getArea(heights, N, leftSmallestElement, rightSmallestElement);
    }

    private int[] getArea(int[] heights, int n, int[] leftSmallestElement, int[] rightSmallestElement) {
        int[] area = new int[n];
        for(int i =0; i<heights.length; i++){
            area[i] = (rightSmallestElement[i] - leftSmallestElement[i] -1)* heights[i];
        }
        return area;
    }
}
