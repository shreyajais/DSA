package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.Easy.PreOrderRecur;

import java.util.ArrayList;
import java.util.List;

public class PostorderRecur {
    public class TreeNode {
        int val;
        PreOrderRecur.TreeNode left;
        PreOrderRecur.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreOrderRecur.TreeNode left, PreOrderRecur.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> postorderTraversal(PreOrderRecur.TreeNode root){
        List<Integer> post = new ArrayList<>();
        preRecur(root, post);
        return post;

    }

    private void preRecur(PreOrderRecur.TreeNode root, List<Integer> post) {
        if(root==null){
            return;
        }
        preRecur(root.left, post);
        preRecur(root.right, post);
        post.add(root.val);
    }
}
