package DSA.StackQueue.Hard;

import java.util.Stack;

public class SumSubArrayMins {
    // https://leetcode.com/problems/sum-of-subarray-minimums/solutions/2118729/very-detailed-stack-explanation-o-n-images-comments
    // Mathematically the total number of subarrays containing 2 can be obtained as follows:
    // arr = [1, 5, 4, 3, 2, 3, 4, 5, 1]
    //Let L = total number of left subarrays = 5
    //Let M = total number of middle subarrays = 1
    //Let R = total number of right subarrays = 5
    //N = Total number of subarrays containing element in middle subarray
    //N = L * M * R = 5 * 1 * 5 = 25
    // for each of the element we will calculate -> subarry where arr[i] will be min.
    // we call nxtSmllEleRight nxtSmllEleLeft --> (i-nseL) * (nseR-i) => all the subArray where arr[i] will be min.

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)Math.pow(10,9) + 7;
        int[] nseLeft = getNextSmallerElementLeft(arr, n);
        int[] nseRight = getNextSmallerElementRight(arr, n);
        long sum =0;
        for(int i =0; i<n; i++){
            int leftSub = i - nseLeft[i];
            int midSub = 1;
            int rightSub = nseRight[i] - i;
            long totalNumOfSubArrayWithIMin = leftSub * midSub * rightSub;
            sum = (sum + totalNumOfSubArrayWithIMin * arr[i])%mod;
        }
        return (int)sum;
    }

    private int[] getNextSmallerElementLeft(int[] arr, int n) {
        int[] nseLeft = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();
            nseLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return nseLeft;
    }

    private int[] getNextSmallerElementRight(int[] arr, int n) {
        int[] nseRight = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();
            nseRight[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nseRight;
    }
    // dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * A[i]);


}
