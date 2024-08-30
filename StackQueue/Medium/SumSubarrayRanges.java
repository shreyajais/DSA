package DSA.StackQueue.Medium;

import java.util.Stack;

public class SumSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int maxSum = sumSubarrayMaxs(nums);
        int minSum = sumSubarrayMins(nums);
        return maxSum-minSum;
    }



    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)Math.pow(10,9) + 7;
        int[] nseLeft = getNextSmallerElementLeft(arr, n);
        int[] nseRight = getNextSmallerElementRight(arr, n);
        int sum =0;
        for(int i =0; i<n; i++){
            int leftSub = i - nseLeft[i];
            int midSub = 1;
            int rightSub = nseRight[i] - i;
            int totalNumOfSubArrayWithIMin = leftSub * midSub * rightSub;
            sum += totalNumOfSubArrayWithIMin * arr[i];
        }
        return sum;
    }

    private int[] getNextSmallerElementLeft(int[] arr, int n) {
        int[] nseLeft = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();
            nseLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return nseLeft;
    }

    private int[] getNextSmallerElementRight(int[] arr, int n) {
        int[] nseRight = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            if(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();
            nseRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nseRight;
    }
    public int sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int mod = (int)Math.pow(10,9) + 7;
        int[] nseLeft = getNextGreaterElementLeft(arr, n);
        int[] nseRight = getNextGreaterElementRight(arr, n);
        int sum =0;
        for(int i =0; i<n; i++){
            int leftSub = i - nseLeft[i];
            int midSub = 1;
            int rightSub = nseRight[i] - i;
            int totalNumOfSubArrayWithIMin = leftSub * midSub * rightSub;
            sum += totalNumOfSubArrayWithIMin * arr[i];
        }
        return sum;
    }

    private int[] getNextGreaterElementLeft(int[] arr, int n) {
        int[] ngeLeft = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(!st.isEmpty() && arr[st.peek()]<= arr[i]) st.pop();
            ngeLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ngeLeft;
    }

    private int[] getNextGreaterElementRight(int[] arr, int n) {
        int[] ngeRight = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            if(!st.isEmpty() && arr[st.peek()]<= arr[i]) st.pop();
            ngeRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ngeRight;
    }
}
