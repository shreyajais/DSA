package DSA.LinkedList;

public class OddEvenIdices {
    public Node oddEvenList(Node head) {
        if(head == null || head.next == null) return head;
        Node oddDummy = new Node(-1);
        Node evenDummy = new Node(-1);
        Node odd = oddDummy;
        Node even = evenDummy;
        Node curr = head;
        int count = 0;
        while(curr!=null){
            Node temp = curr;
            curr = curr.next;
            temp.next = null;
            if(count%2==0){
                even.next = temp;
                even = even.next;
            }else {
                odd.next = temp;
                odd = odd.next;
            }
            count++;
        }
        even.next = oddDummy.next;
        return evenDummy.next;
    }
}
