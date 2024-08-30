package DSA.Greedy;

import java.util.Arrays;

public class MinimumCoinsMakeSum {
    int minCoins(int coins[], int m, int sum) {
       Arrays.sort(coins, (a,b)-> b-a);
    }
}
