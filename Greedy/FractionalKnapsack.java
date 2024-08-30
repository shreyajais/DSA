package DSA.Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, (a,b)-> (b.value/b.weight)-(a.value/a.weight));
        int wtLeftNow = w, i = 0;
        double valueSoFar = 0;
        while(wtLeftNow>0 && i<n){
            if(arr[i].weight<=wtLeftNow){
                wtLeftNow -= arr[i].weight;
                valueSoFar += arr[i].value;
            }else{
                valueSoFar += ((double) arr[i].value/(double) arr[i].weight)*wtLeftNow;
                wtLeftNow = 0;
            }
        }
        return valueSoFar;
    }
}
