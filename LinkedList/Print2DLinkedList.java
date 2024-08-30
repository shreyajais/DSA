package DSA.LinkedList;

public class Print2DLinkedList {
    class Node{
        int value; Node next; Node child;

        public Node(int value, Node next, Node child) {
            this.value = value;
            this.next = next;
            this.child = child;
        }
    }
    public static void printLL(Node head, int depth){
        while(head!=null){
            System.out.print(head.value);
            if(head.child!=null){
                System.out.print("->");
                printLL(head.child, depth+1);
            }
            for(int i =0; i<depth; i++){
                System.out.println("|");
            }
            head = head.next;
        }
    }
}
