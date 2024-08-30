package DSA.BinarySearch.BasicsToMed;

public class SquareRoot {
    long floorSqrt(long n) {
        long low = 1, high = n;
        while(low<=high){
            long mid = low + (high-low)/2;
            long sqr = mid*mid;
            if(sqr == n) return mid;
            else if(sqr < n) low = mid +1;
            else high = mid-1;
        }
        return high;
    }
}
