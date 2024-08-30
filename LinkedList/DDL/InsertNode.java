package DSA.LinkedList.DDL;



public class InsertNode {
    void addNode(Node head_ref, int pos, int data)
    {
        Node newNode = new Node(data);
        Node n = head_ref;
        for(int i =0; i<=pos && n !=null ; i++){
            n = n.next;
        }
        if(n!=null){
            addToNode(n, newNode);
        }
    }
    private void addToNode(Node toAdd, Node newNode){
        newNode.prev = toAdd;
        newNode.next = toAdd.next;
        toAdd.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;
    }
}

/*
* LinkedList: 2<->4<->5
p = 2, x = 6
Output: 2 4 5 6
Explanation: p = 2, and x = 6. So, 6 is
inserted after p, i.e, at position 3
(0-based indexing).*/
