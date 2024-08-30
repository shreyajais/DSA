package DSA.Basic.Recursion;

public class Sum {
    long sumOfSeries(long n) {
        // code here
        if(n == 1) return 1;
        //return (long)(Math.pow(n, 3) + sumOfSeries(n-1)); // should not use cast
        return n*n*n + sumOfSeries(n-1);
    }
}
