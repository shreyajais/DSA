package DSA.BinaryTrees.Easy;

import java.util.ArrayList;
import java.util.List;

public class PreOrderRecur {
    public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        preRecur(root, pre);
        return pre;

    }

    private void preRecur(TreeNode root, List<Integer> pre) {
        if(root==null){
            return;
        }
        pre.add(root.val);
        preRecur(root.left, pre);
        preRecur(root.right, pre);
    }

}
