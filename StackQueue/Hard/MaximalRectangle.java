package DSA.StackQueue.Hard;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp= new int[m][n];
        for(int j = 0; j<m; j++){
            dp[0][j] = matrix[0][j] == '1' ? 1: 0;
        }
        for(int i =1; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = matrix[i][j] == '1' ? dp[i-1][j] +1 : 0;
            }
        }
        int max = 0;
        for(int i =0; i<m; i++){
            int maxAreaPerRow = largestRectangleArea(dp[i]);
            max = Math.max(max, maxAreaPerRow);
        }
        return max;
    }




    // question histogram --> copy paste
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
