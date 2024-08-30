package DSA.Greedy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PageFaultsLRU {
    static int pageFaults(int N, int C, int pages[]){
        int count = 0;
        LinkedList<Integer> ll = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<pages.length; i++){
            if(s.contains(pages[i])){
                ll.remove(pages[i]);
                ll.add(pages[i]);
            } else {
                count++;
                if(s.size()==C){
                    int removeVal = ll.get(0);
                    ll.removeFirst();
                    s.remove(removeVal);
                }
                ll.add(pages[i]);
            }
        }
        return count;
    }


}
