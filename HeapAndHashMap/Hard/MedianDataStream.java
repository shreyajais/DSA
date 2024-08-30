package DSA.HeapAndHashMap.Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianDataStream {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianDataStream() {
        pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
       if(!pq2.isEmpty() && pq2.peek()<= num) pq2.add(num);
       else pq1.add(num);
       if(pq1.size() > pq2.size() && (pq1.size()- pq2.size())>1) pq2.add(pq1.remove());
       if(pq1.size() < pq2.size() && (pq2.size()- pq1.size())>1) pq1.add(pq2.remove());
    }

    public double findMedian() {
        if(sizeStream() == 0) return -1;
        if(pq1.size()>pq2.size()) return pq1.peek();
        else if(pq1.size()<pq2.size()) return pq2.peek();
        else return ((double)(pq1.peek() + pq2.peek())/(double) 2);
    }
    private int sizeStream(){
        return pq1.size() + pq2.size();
    }
}
