package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.*;

public class VerticalTraversal {
    class Node{
        TreeNode treeNode;
        int x;
        int y;
        Node(TreeNode treeNode, int x, int y){
            this.treeNode = treeNode;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Map<Integer, Map<Integer, ArrayList<Integer>>> mp = new HashMap<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0,0));
        while(!q.isEmpty()){
            int sizeQ = q.size();
            int nodeCount = 0;
            while(nodeCount<=sizeQ){
                Node n = q.remove();
                maxX = Math.max(maxX, n.x);
                minX = Math.min(minX, n.x);


                if(mp.containsKey(n.x)){
                    Map<Integer, ArrayList<Integer>> mpY = mp.get(n.x);
                    ArrayList<Integer> yList;
                    if(mpY.containsKey(n.y)){
                        yList = mpY.get(n.y);
                    } else {
                        yList = new ArrayList<>();
                    }
                    yList.add(n.treeNode.val);
                    mp.put(n.x, mpY);
                } else {
                    ArrayList<Integer> yList = new ArrayList<>();
                    yList.add(n.treeNode.val);
                    Map<Integer, ArrayList<Integer>> mpY = new HashMap<>();
                    mpY.put(n.y, yList);
                    mp.put(n.x, mpY);
                }

                if(n.treeNode.left !=null) q.add(new Node(n.treeNode.left, n.x-1, n.y+1));
                if(n.treeNode.right !=null) q.add(new Node(n.treeNode.right, n.x+1, n.y+1));
                nodeCount++;
            }
        }
        for(int k =minX ; k<=maxX; k++){
            Map<Integer, ArrayList<Integer>> mapToAdd = mp.get(k);
            ArrayList<Integer> xList = new ArrayList<>();
            for(ArrayList<Integer> l: mapToAdd)
            // sort dec when x and y both are same.
            ans.add(listToAdd);
        }
        return ans;

    }
}
