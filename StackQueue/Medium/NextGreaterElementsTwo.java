package DSA.StackQueue.Medium;

import java.util.Stack;

public class NextGreaterElementsTwo {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 2*n-1; i>=0; i++){
            while(!st.isEmpty() && st.peek()< nums[i%n]) st.pop();
            if(st.isEmpty()) ans[i%n] = -1;
            else ans[i%n] = st.peek();
            st.push(nums[i%n]);
        }
        return ans;
    }
}
