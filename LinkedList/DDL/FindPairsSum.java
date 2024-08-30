package DSA.LinkedList.DDL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindPairsSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        Node n = head;
        while(n!=null){
            if(s.contains(target-n.val)){
                ArrayList<Integer> p = new ArrayList<>();
                p.add(target-n.val);
                p.add(n.val);
                ans.add(p);
                s.remove(target-n.val);
            } else s.add(n.val);
            n= n.next;
        }
        Collections.sort(ans, (a,b) -> a.get(0) - b.get(0));
        return ans;
    }
}
