package DSA.LinkedList;

public class AdTwoNumbers {
    class ListNode{
        int val; ListNode next;

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode n1 = l1, n2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        while(n1!=null && n2!= null){
            sum = n1.val + n2.val + carry;
            ListNode n = new ListNode(sum%10);
            dummy.next = n;
            carry = sum/10;
            n1 = n1.next;
            n2 = n2.next;
        }
        while(n1!=null){
            sum = n1.val + carry;
            ListNode n = new ListNode(sum%10);
            dummy.next = n;
            carry = sum/10;
            n1 = n1.next;
        }
        while(n2!=null){
            sum = n2.val + carry;
            ListNode n = new ListNode(sum%10);
            dummy.next = n;
            carry = sum/10;
            n2 = n2.next;
        }
        if(carry >0){
            ListNode n = new ListNode(carry);
            dummy.next = n;
        }
        return dummyHead.next;
    }
}
