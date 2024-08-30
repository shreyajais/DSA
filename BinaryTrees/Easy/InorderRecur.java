package DSA.BinaryTrees.Easy;

import java.util.ArrayList;
import java.util.List;

public class InorderRecur {
    public class TreeNode {
        int val;
        PreOrderRecur.TreeNode left;
        PreOrderRecur.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, PreOrderRecur.TreeNode left, PreOrderRecur.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        public List<Integer> inorderTraversal(PreOrderRecur.TreeNode root){
            List<Integer> in = new ArrayList<>();
            inRecur(root, in);
            return in;

        }

        private void inRecur(PreOrderRecur.TreeNode root, List<Integer> in) {
            if(root==null){
                return;
            }
            inRecur(root.left, in);
            in.add(root.val);
            inRecur(root.right, in);
        }
}
