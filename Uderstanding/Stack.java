package DSA.Uderstanding;

public class Stack {

    /*
    Monotonic stack A function is said to be monotonic if it preserves a given order.
    A monotonically increasing function never decreases.
    Likewise, a monotonically decreasing function never increases.
Similarly, a monotonic stack contains elements that preserve a given order.
A monotone increasing stack contains elements that never decrease.
Likewise, a monotone decreasing stack contains elements that never increase.

    * */

    public int[] nextGreaterElementsSOL(int[] nums) {
        int[] res = new int[nums.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    // gpt solution
    // this is not the next greatest ---> its the greatest left and right so far.
    public class TrapWater {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;

            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int water = 0;
            for (int i = 1; i < n - 1; i++) {
                water += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return water;
        }
    }
    // leetcode solution with stack ---> monotonic stack
    public int trapMono(int[] height) {
        int l = 0, r = height.length - 1; // Initialize two pointers, one at the beginning and one at the end of the height array
        int leftMax = -1, rightMax = -1; // Initialize variables to store the maximum height encountered so far from the left and right sides
        int water = 0; // Initialize a variable to store the total trapped water

        // Traverse the height array from both ends towards each other until the pointers meet
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]); // Update the maximum height encountered from the left side
            rightMax = Math.max(rightMax, height[r]); // Update the maximum height encountered from the right side

            // Calculate the trapped water based on the lower maximum height encountered so far (between leftMax and rightMax)
            // If leftMax is less than rightMax, the current height at index l can trap water, otherwise, the current height at index r can trap water
            if (leftMax < rightMax)
                water += leftMax - height[l++];
            else
                water += rightMax - height[r--];
        }

        return water; // Return the total trapped water
    }
}
// a+b*(c^d-e)^(f+g*h)-i=> st
