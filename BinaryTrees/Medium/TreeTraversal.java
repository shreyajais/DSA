package DSA.BinaryTrees.Medium;
import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    static class Pair{
        TreeNode n;
        int state;
        Pair(TreeNode n, int state){
            this.n= n;
            this.state = state;
        }
        void setState(int state){
            this.state = state;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        while(st.size()>0){
            Pair p = st.pop();
            TreeNode pn = p.n;
            if(p.state==1){
                pre.add(pn.val);
                p.setState(2);
                st.push(p);
                if(pn.left!=null) st.push(new Pair(pn.left, 1));
            }else if(p.state==2){
                in.add(pn.val);
                p.setState(3);
                st.push(p);
                if(pn.right!=null) st.push(new Pair(pn.right, 1));
            }else post.add(pn.val);

        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
