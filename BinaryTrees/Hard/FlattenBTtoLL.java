package DSA.BinaryTrees.Hard;

import DSA.BinaryTrees.TreeNode;

public class FlattenBTtoLL {
    public void flatten(TreeNode root) {
        if(root == null || isLeaf(root)) return;
        TreeNode curr = root;
        while(curr!= null){
            if(curr.left!=null){
                TreeNode prev = curr.left;
                while(prev.right != null) prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    private boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }
}
