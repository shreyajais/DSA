package DSA.LinkedList;

public class MergeTwoSortedLists {
    public Node mergeTwoLists(Node list1, Node list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        Node dummuyHead = new Node(-1);
        Node temp = dummuyHead;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while(list1!=null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2!=null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return dummuyHead.next;
    }
}
