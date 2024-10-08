package DSA.Greedy;

public class CandyGreaterThanNeigbour {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        // atleast one candy
        int count = n;
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) candies[i]= candies[i-1]+1;
        }
        for(int i= n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1] && candies[i]<= candies[i+1]) candies[i] = candies[i+1]+1;
        }
        for (int i =0; i<n; i++) count += candies[i];
        return count;
    }
}
