package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int sizeOfQueue = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i=0; i < sizeOfQueue; i++) {
                TreeNode n = q.remove();
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
                l.add(n.val);
            }
            ans.add(l);
        }
        return ans;
    }
}
