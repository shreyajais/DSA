package DSA.BinarySearchTrees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isValidBSTRecur(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean isValidBSTRecur(TreeNode node, long max, long min){
        if(node==null) return true;
        if(node.val<=min || node.val>=max) return false;
        return isValidBSTRecur(node.left, node.val, min) && isValidBSTRecur(node.right, max, node.val);
    }
}
