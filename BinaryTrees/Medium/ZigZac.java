package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.*;

public class ZigZac {
    public List<List<Integer>> zigZacOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        int sign = 1;
        q.add(root);
        while (q.size() > 0) {
            int sizeOfQueue = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i=0; i < sizeOfQueue; i++) {
                TreeNode n;
                if(sign==1){
                    n = q.removeFirst();
                    if(n.left!=null) q.addLast(n.left);
                    if(n.right!=null) q.addLast(n.right);
                } else {
                    n = q.removeLast();
                    if(n.right!=null) q.addFirst(n.right);
                    if(n.left!=null) q.addFirst(n.left);
                }
                l.add(n.val);
            }
            ans.add(l);
            sign = sign * (-1);
        }
        return ans;
    }
}
