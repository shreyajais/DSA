package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

public class Identical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if((p== null && q!=null) || (p!= null && q==null)) return false;
        else if(p.val!=q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
