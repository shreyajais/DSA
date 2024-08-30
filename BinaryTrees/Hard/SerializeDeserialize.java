package DSA.BinaryTrees.Hard;

import DSA.BinaryTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    public String serialize(TreeNode root) {
        //return serializeRecur(root, "");
        if(root==null) return "";
        String st = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.val == Integer.MAX_VALUE){
                st+= "#";
                continue;
            }
            st+=n.val;
            if(n.left!= null){
                q.add(n.left);
            } else
            if(n.left!= null){
                q.add(n.left);
                st += n.val + ",";
            } else st += "#,";
        }
        return st;
    }

    public String serializeRecur(TreeNode root, String strSoFar){
        if(root== null) return strSoFar + "#";
        else if(isLeaf(root)) return strSoFar + root.val + "#" + "#";
        else {
            String left = serializeRecur(root.left , strSoFar);
            String right = serializeRecur(root.right , strSoFar);
            return root.val + left + right;
        }
    }

    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] strArr = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strArr[index]));
        q.add(root);
        index++;
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(strArr[index] != "#"){
                n.left = new TreeNode(Integer.parseInt(strArr[index]));
                q.add(n.left);
            } else n.left = null;
            index++;
            if(strArr[index] != "#"){
                n.right = new TreeNode(Integer.parseInt(strArr[index]));
                q.add(n.right);
            } else n.right = null;
            index++;
        }
        return root;
    }
    private boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }
}
