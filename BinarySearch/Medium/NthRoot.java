package DSA.BinarySearch.Medium;

public class NthRoot {
    public int NthRoot(int n, int m)
    {
        int low = 1, high = m;
        while(low<=high){
            int mid = low + (high-low)/2;
            int isEqual = compareProd(mid, n, m);
            if(isEqual == 0) return mid;
            else if(isEqual == -1) low = mid +1;
            else high = mid-1;
        }
        return -1;
    }

    private int compareProd(int mid, int n, int m) {
        int i =1;
        long prod = 1;
        while(i<=n){
            prod*=mid;
            if(prod > m) return -1;
            i++;
        }
        return prod == m ? 0: -1;
    }



}
