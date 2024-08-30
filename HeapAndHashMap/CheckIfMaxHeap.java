package DSA.HeapAndHashMap;

public class CheckIfMaxHeap {
    public boolean countSub(long arr[], long n)
    {
        for(long i = n-1; i>0; i--){
            long parent = getParent(i);
            if(arr[(int)parent]< arr[(int)i]) return false;
        }
        return true;
    }
    private long getParent(long i){
        return (i-1)/2;
    }
    private long leftChild(long i){
        return (2*i+1)/2;
    }
    private long rightChild(long i){
        return (2*i+2)/2;
    }
}
