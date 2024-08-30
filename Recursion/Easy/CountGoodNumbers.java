package DSA.Recursion.Easy;

public class CountGoodNumbers {
    public int countGoodNumbers(long n) {
        int numberOfEvenDigits = 5; // 0, 2, 3, 6, 8
        int numberOfPrimeDigits = 4; // 2, 3, 5, 7
        int mod = (int) Math.pow(10, 9) + 7;
        if(n%2==0){
            return (powerCal(5, n/2, mod) * powerCal(4, n/2, mod))%mod;
        } else {
            return (5 * powerCal(5, (n-1)/2, mod)* powerCal(4, (n-1)/2, mod))%mod;
        }
    }

    private int powerCal(int val, long pow, int mod) {
        if(pow == 0) return 1;
        else if(pow == 1) return val;
        else {
            int halfValue = 1;
            if(pow%2 == 0){
                halfValue = powerCal(val, pow/2, mod);
                return (halfValue * halfValue)%mod;
            } else {
                halfValue = powerCal(val, (pow-1)/2, mod);
                return (val * halfValue * halfValue)%mod;
            }
        }
    }

    private int countNumbers(int i, long n, int numberOfEvenDigits, int numberOfPrimeDigits, int mod) {
        if(i == n) return 1;
        if(i%2==0) return (numberOfEvenDigits * countNumbers(i+1, n, numberOfEvenDigits, numberOfPrimeDigits, mod))%mod;
        else return (numberOfPrimeDigits * countNumbers(i+1, n, numberOfEvenDigits, numberOfPrimeDigits, mod))%mod;
    }

}
