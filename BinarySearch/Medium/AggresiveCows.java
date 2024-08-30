package DSA.BinarySearch.Medium;

public class AggresiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        int low = 1;
        int n = stalls.length; // count the number of stalls
        int high = stalls[n - 1] - stalls[0];
        while(low<=high){
            int mid = (high+low)/2;
            if(canFitCows(stalls, k, mid)) low = mid+1;
            else high = mid-1;
        }
        return high;
    }

    private static boolean canFitCows(int []stalls, int k, int dist){
        int count = 1;
        int lastFilled = stalls[0];
        int index = 1;
        int n = stalls.length;
        while(lastFilled<n){
            if(Math.abs(stalls[index]-lastFilled)>=dist){
                lastFilled = index;
                count++;
            }
            if(count>=k) return true;
            index++;
        }
        return false;
    }
}
