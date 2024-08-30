package DSA.BinaryTrees.Easy;

import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageValues {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null ){
            ans.add(0.0); return ans;
        }
        if(isLeaf(root)){
            ans.add((double) root.val);
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           int size = q.size();
           int sum = 0;
           for(int i =0; i<size; i++){
               TreeNode n = q.poll();
               sum += n.val;
               if(isLeaf(n)) continue;
               if(n.left!= null) q.add(n.left);
               if(n.right != null) q.add(n.right);
           }
           ans.add(((double)sum/(double)size));
        }
        return ans;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left== null && root.right == null;
    }
}
