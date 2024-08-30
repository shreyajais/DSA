package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

public class HeightBT {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
