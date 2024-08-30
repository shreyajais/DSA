package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

public class Diameter {
    int maxDepth = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        return (int)Math.max(maxDepthFromNode(root), maxDepth)-1;
    }
    public int maxDepthFromNode(TreeNode root){
        if(root==null) return 0;
        else {
            int leftBranch = maxDepthFromNode(root.left);
            int rightBranch = maxDepthFromNode(root.right);
            maxDepth = (int)Math.max(maxDepth, (leftBranch + rightBranch + 1));
            return 1+ Math.max(leftBranch, rightBranch);
        }
    }
}
