package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

public class MinDifference {
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        if(isLeaf(root)) return root.val;
        return minDiffRecur(root);

    }

    private int minDiffRecur(TreeNode root) {
        if(root == null) return 0;
        else if(isLeaf(root)) return root.val;


    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
