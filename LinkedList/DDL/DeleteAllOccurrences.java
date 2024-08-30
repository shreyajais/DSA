package DSA.LinkedList.DDL;

public class DeleteAllOccurrences {
    static Node deleteAllOccurOfX(Node head, int x) {
        if(head == null) return null;
        Node newHead = getNewHead(head, x);
        Node n = newHead.next;
        while(n!= null){
            if(n.val == x){
                  n.prev.next = n.next;
                  if(n.next != null) n.next.prev = n.prev;
            } else n = n.next;
        }
        return newHead;
    }

    private static Node getNewHead(Node head, int x) {
        while(head!=null){
            if(head.val != x) return head;
            head = head.next;
        }
        return null;
    }
}
