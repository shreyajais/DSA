package DSA.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Representation {
    static class Node {
        Node left; Node right; int val;

        public Node(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
    public static void createTree(Node root0, ArrayList<Integer> v ){
        Queue<Node> q = new LinkedList<>();
        q.add(root0);
        int level =0;
        while(q.isEmpty()){
            int sizeQ = q.size();
            for(int i= 0; i<sizeQ; i++){
                Node parent = q.peek();
                int leftValue = v.size()-1 > 2*level +1 ? v.get(2*level +1): -1;
                int rightValue =v.size()-1 > 2*level +1 ? v.get(2*level +2): -1;
                Node newLeft =  leftValue != -1 ? new Node(leftValue): null;
                parent.left = newLeft;
                Node newRight = rightValue != -1 ? new Node(rightValue): null;
                parent.right = newRight;
                q.add(newLeft);
                q.add(newRight);
            }
            level++;
        }
    }
}
