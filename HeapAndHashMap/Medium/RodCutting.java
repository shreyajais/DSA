package DSA.HeapAndHashMap.Medium;

import java.util.PriorityQueue;

public class RodCutting {
    class Pair implements Comparable<Pair>{
        int length; int val;

        public Pair(int val, int length) {
            this.val = val;
            this.length = length;
        }

        @Override
        public int compareTo(Pair other) {
            double ratio1 = (double) this.val / this.length;
            double ratio2 = (double) other.val / other.length;
            return Double.compare(ratio2, ratio1);
        }
        //// vvvvvvv above two yeids different results why ??

//        @Override
//        public int compareTo(Pair o) {
//            double r1 = (double)o.val/(double)o.length;
//            double r2 = (double)this.val/(double)this.length;
//            return Double.compare(r2, r1);
//        }
    }

    public int cutRod(int price[], int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0; i< price.length; i++){
            pq.add(new Pair(price[i], i+1));
        }
        int lengthLeft = n;
        int amountSoFar = 0;
        while(!pq.isEmpty()){ // N > 0
            Pair p = pq.remove();
            if(lengthLeft>=p.length){
                int quantity = lengthLeft/p.length;
                amountSoFar += p.val+quantity;
                lengthLeft -= p.length*quantity;
                if(lengthLeft==0) return amountSoFar;
            }
        }
        return amountSoFar;
    }
}
