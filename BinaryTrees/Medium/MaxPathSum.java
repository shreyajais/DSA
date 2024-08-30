package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

public class MaxPathSum {
    int maxDepthSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        return (int)Math.max(maxDepthFromNodeSum(root), maxDepthSum);
    }

    private int maxDepthFromNodeSum(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepthFromNodeSum(root.left);
        int right = maxDepthFromNodeSum(root.left);
        //@Important
        maxDepthSum = Math.max(root.val, Math.max(maxDepthSum, left + right+ root.val));
        return Math.max(root.val, root.val + (int) Math.max(left, right));
    }
}
