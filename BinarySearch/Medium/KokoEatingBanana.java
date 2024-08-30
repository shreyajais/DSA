package DSA.BinarySearch.Medium;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        if(isPossibleToEatAtMaxSpeed(piles.length, h)) return -1;
        int low = 1; // 1 banana/hr ----> so number of banana it can eat = h
        int high =  getMaxBananaPerPile(piles);// 1pie/hr whole pie each hour so can eat max banana pie is the speed
        if(piles.length == h) return high;
        if(canEatAtlowestSpeed(piles, h)) return 1;
        while(low<=high){
            int mid = (low+high)/2;
            int timeReqToEat = totalTimeToEat(piles, mid);
            if(timeReqToEat == -1 || timeReqToEat>h) low = mid+1;
            else high = mid -1;
        }
        return low;
    }

    private int totalTimeToEat(int[] piles, int mid) {
        int totalHrs = 0;
        for(int i =0; i<piles.length; i++){
            if(piles[i]%mid == 0) totalHrs += (piles[i]/mid);
            else totalHrs += (piles[i]/mid + 1);
        }
        return totalHrs;
    }

    private boolean canEatAtlowestSpeed(int[] piles, int h) {
        int sum = 0;
        for(int i =0; i<piles.length; i++) sum += piles[i];
        return sum<=h;
    }

    private boolean isPossibleToEatAtMaxSpeed(int pilesLength, int h) {
        // eating at 1 pile in one hour.
        return pilesLength > h;
    }

    private int getMaxBananaPerPile(int[] piles) {
        int max = piles[0];
        for(int i =1; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
