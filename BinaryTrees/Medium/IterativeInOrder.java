package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.peek();
            if(top.left != null){
                st.push(top.left); continue;
            }
            else ans.add(st.pop().val);
            if(top.right != null) st.push(top.right);
            else ans.add(st.pop().val);
        }
        return ans;
    }
}
