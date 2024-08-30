package DSA.LinkedList;

public class OddEvenValuedLL {
    public static Node oddEven(Node head){
        Node evenHead = new Node(-1);
        Node even = evenHead;
        Node oddHead = new Node(-1);;
        Node odd = oddHead;
        Node curr = head;
        while(curr!=null){
            Node temp = curr;
            curr = curr.next;
            temp.next = null;
            if(temp.val%2==0){
                even.next = temp;
                even = even.next;
            }else {
                odd.next = temp;
                odd = odd.next;
            }
        }
        if(oddHead.next == null) return evenHead.next;
        if(evenHead.next == null) return oddHead.next;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
