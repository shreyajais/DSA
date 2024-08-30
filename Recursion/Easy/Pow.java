package DSA.Recursion.Easy;

public class Pow {
    public double myPow(double x, int n){
        double pow = getMyPow(x, Math.abs(n));
        if(n<0){
            return 1/pow;
        } else return pow;
    }

    private double getMyPow(double x, int n) {
        if(n==0) return 1;
        double val;
        if(n%2==0){
          return getMyPow(x * x, n/2);
        } else {
            return  x* getMyPow(x * x, (n-1)/2);
        }
    }
}