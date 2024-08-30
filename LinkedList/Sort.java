package DSA.LinkedList;

public class Sort {
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow =  head;
        Node fast = head;
        while(fast!= null || fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node l1 = head;
        Node l2 = slow.next;
        slow.next = null; // important
        l1 = sortList(l1);
        l2 = sortList(l2);
        return merge(l1, l2);
    }
    private Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node dummyHead = dummy;
        while(l1!= null && l2!= null){
            if(l1.val<= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        while(l1!= null){
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while(l2!=null){
            dummy.next = l2;
            l2= l2.next;
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}
