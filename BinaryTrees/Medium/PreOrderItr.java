package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderItr {

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode n = st.pop();
            pre.add(n.val);
            if(n.left!= null) st.add(n.left);
            if(n.right!= null) st.add(n.right);
        }
        return pre;

    }
}
