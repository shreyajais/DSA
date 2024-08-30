package DSA.BinarySearchTrees;

import java.util.Stack;

public class TreeIterator {
    Stack<TreeNode> st;
    public void BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }
    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(TreeNode node) {
        TreeNode n = node;
        while(n!= null){
            st.push(n);
            n = n.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
