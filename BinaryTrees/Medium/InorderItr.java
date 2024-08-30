package DSA.BinaryTrees.Medium;

import java.util.*;

public class InorderItr {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.peek();
            if(n.left!= null) q.add(n.left);
            if(n.right!= null) st.add(n.right);
        }
        return pre;

    }
}
