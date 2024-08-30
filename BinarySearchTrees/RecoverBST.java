package DSA.BinarySearchTrees;

public class RecoverBST {
    TreeNode prev = null, left = null, mid = null, right = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(left == null) return;
        int temp = left.val;
        if(right != null){
            left.val = right.val;
            right.val = temp;
        } else {
            left.val = mid.val;
            mid.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val > root.val){
            if(left==null){
                left = prev;
                mid = root;
            } else {
                right = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
