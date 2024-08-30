package DSA.LinkedList;

public class Sort0s1s2s {
    static Node segregate(Node head) {
        Node zero = new Node(-1), one =new Node(-1), two = new Node(-1); // this is new learning
        Node i = head;
        Node newZeroHead = null, newOneHead = null, newTwoHead = null;
        Node temp = null;
        while(i!=null){
            temp = i.next;
            i.next = null;
            if(i.val == 0){
                zero.next = i;
                if(zero.val == -1) newZeroHead = zero.next;
                zero = zero.next;
            } else if(i.val == 1){
                one.next = i;
                if(one.val == -1) newOneHead = one.next;
                one = one.next;
            } else {
                two.next = i;
                if(two.val == -1) newTwoHead = two.next;
                two = two.next;
            }
            i = temp;
        }
        // important conditions for null factors
        zero.next = newOneHead != null ? newOneHead : newTwoHead;
        one.next = newTwoHead;
        return newZeroHead != null ? newZeroHead : (newOneHead != null ? newOneHead: newTwoHead);
    }
}
