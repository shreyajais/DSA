package DSA.LinkedList;

public class Palindrome {
    public boolean isPalindrome(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) Node l2 = reverse(slow);
        else Node l2 = reverse(slow.next)
    }
    public boolean compare(Node l1, Node l2){
        while(l1!=null && l2!=null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public Node reverse(Node n){
        Node dummy = new Node(-1);
        Node curr = n;
        while(curr != null){
            Node temp = curr;
            curr = curr.next;
            temp.next = dummy;
            dummy = temp;

        }
    }
}
