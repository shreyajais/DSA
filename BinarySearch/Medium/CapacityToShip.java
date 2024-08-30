package DSA.BinarySearch.Medium;

public class CapacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        int numberOfPkg = weights.length;
        int minCap = getMaxWtPkg(weights, numberOfPkg);// minCap---> max days if load each day 1 pakg = weights.length( cap = max of all wt of pkg)
        int maxCap = getSumOfAllPkg(weights, numberOfPkg); // maxCap --> min days to load and ship = 1 day(cap = sum of all pakg)
        int low = minCap, high = maxCap;
        while(low<=high){
            int midCap = low + (high - low)/2;
            if(isPossibleToShip(weights, days, midCap)) high = midCap-1;
            else low = midCap+1;
        }
        return low;
    }

    private boolean isPossibleToShip(int[] weights, int daysLimit, int midCap) {
        int daysCount = 1; // days or time always start with 1 not 0;
        int capacityLeft = midCap;
        for(int i =0; i<weights.length; i++){
            if(capacityLeft<weights[i]){
                daysCount++;
                capacityLeft = midCap;
            }
            capacityLeft -= weights[i];
        }
        return daysCount<= daysLimit;
    }

    private int getSumOfAllPkg(int[] weights, int numberOfPkg) {
        int sumOfWt = 0;
        for(int i =0; i<numberOfPkg; i++) sumOfWt += weights[i];
        return sumOfWt;
    }

    private int getMaxWtPkg(int[] weights, int numberOfPkg) {
        int maxWt = weights[0];
        for(int i =1; i< numberOfPkg; i++) maxWt = Math.max(maxWt, weights[i]);
        return maxWt;
    }
}
