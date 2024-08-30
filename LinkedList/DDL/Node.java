package DSA.LinkedList.DDL;

public class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
    }


    public Node() {
        this.val = 0;
        this.next = null;
    }
}
