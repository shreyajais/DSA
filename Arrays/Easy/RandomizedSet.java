package DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {
    class Node{
        int val; Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    Map<Integer, Node> map;
    public RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        int llVal = val%32;
        Node n = new Node(val);
        if(map.containsKey(llVal)){
            Node ll = map.get(llVal);
            if(ll.val> val){
                n.next = ll;
                map.put(llVal, n);
            } else {
                Node start = ll;
                while(start.next != null && start.next.val< val) start = start.next;
                if(start.next == null) start.next = n;
                else{
                    n.next = start.next;
                    start.next = n;
                }
            }
        } else map.put(llVal, n);
        return
    }

    public boolean remove(int val) {
        int llVal = val%32;
        Node
    }

    public int getRandom() {

    }
}
