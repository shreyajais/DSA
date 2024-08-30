package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

public class Balance {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    public int checkBalance(TreeNode root){
        if(root==null) return 0;
        else {
            int leftHeight = checkBalance(root.left);
            int rightHeight = checkBalance(root.right);
            if(leftHeight==-1 || rightHeight == -1) return -1;
            else if((int)Math.abs(leftHeight-rightHeight)>1) return -1;
            else return 1+ Math.max(leftHeight, rightHeight);
        }
    }
}
