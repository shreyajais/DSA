package DSA.BinarySearch.Medium;

public class MinDaysMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int noOfFlowers = bloomDay.length;
        int maxBouqets = noOfFlowers/k;
        if(maxBouqets<m) return -1;
        int[] maxMin = getMaxMin(bloomDay);
        int low = maxMin[1]; //min(bloomDay) ---> 1 flower 1 bouquest
        int high = maxMin[0]; //max(bloomDay) ---> all flower 1 bouquest with a k = len, or m = len and 1 adjacent
        if(maxBouqets==m) return high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossibleToMakeBouquest(bloomDay, m, k, mid)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private boolean isPossibleToMakeBouquest(int[] bloomDay, int m, int k, int mid) {
        int countFlower = 0, countBouqet = 0;
        for(int i =0; i<bloomDay.length; i++){
            if(bloomDay[i]<=mid){
                countFlower ++;
            } else {
                countBouqet += countFlower/k;
                countFlower = 0;
            }
        }
        countBouqet += countFlower/k; // the last slot/// vv imp
        return countBouqet == m;
    }

    private int[] getMaxMin(int[] bloomDay) {
        int[] maxMin = new int[2];
        int max = bloomDay[0], min = bloomDay[0];
        for(int i =1; i< bloomDay.length; i++){
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }
        maxMin[0] = max;
        maxMin[1] = min;
        return maxMin;
    }

}
