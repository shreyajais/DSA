package DSA.LinkedList;

public class Fatten {
    class Node{
        int val; Node bottom; Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node bottom, Node next) {
            this.val = val;
            this.bottom = bottom;
            this.next = next;
        }
    }
    Node flatten(Node root) {
        // code here
        if(root == null || root.next == null) return root;
        Node mergeRoot = flatten(root.next);
        return mergeLL(root, mergeRoot);
    }

    private Node mergeLL(Node l1, Node l2) {

        Node dummy = new Node(-1);
        Node dummyHead = dummy;

        while(l1.bottom != null && l2.bottom != null){
            if(l1.val< l2.val){
                dummy.bottom = l1;
                l1 = l1.bottom;
            } else {
                dummy.bottom = l2;
                l2 = l2.bottom;
            }
            dummy = dummy.bottom;
        }
        if(l1!= null) dummy.bottom = l1;
        else dummy.bottom = l2;

       return dummyHead.next;
    }
}
