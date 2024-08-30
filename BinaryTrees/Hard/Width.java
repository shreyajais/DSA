package DSA.BinaryTrees.Hard;

import DSA.BinaryTrees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Width {
    // to substact from first and last --->  //int mmin = q.peek().getValue();
    class PairNode{
        TreeNode n; int index;

        public PairNode(TreeNode n, int index) {
            this.n = n;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        if (isLeaf(root)) return 1;
        Deque<PairNode> q = new LinkedList<>();
        q.add(new PairNode(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()){
            int

        }
    }

    private boolean isLeaf(TreeNode root) {
    }





}
