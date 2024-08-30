package DSA.BinarySearch.Medium;

import java.util.ArrayList;

public class PaintersPartition {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int n = boards.size();
        if(k>n) return -1;
        if(k==n) return getMaxPages(boards, n);
        int low = getMaxPages(boards, n);
        int high = getSumOfAllPages(boards, n);
        while(low<=high){
            int mid = (low+high)/2;
            if(canReadBook(boards, n, k, mid)) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private static boolean canReadBook(ArrayList<Integer> arr, int n, int m, int maxPages) {
        int countReaders = 0;
        int pagesToRead = maxPages;
        int i=0;
        while(i<n && countReaders<m){
            if(arr.get(i)>pagesToRead){
                countReaders++;
                pagesToRead = maxPages;
            }
            pagesToRead -= arr.get(i);
            i++;
        }
        return countReaders == m;
    }
    private static int getSumOfAllPages(ArrayList<Integer> arr, int n) {
        int sum = 0;
        for(int i =0; i<n; i++){
            sum += arr.get(i);
        }
        return sum;
    }

    private static int getMaxPages(ArrayList<Integer> arr, int n) {
        int max = arr.get(0);
        for(int i =1; i<n; i++){
            max = Math.max(max, arr.get(i));
        }
        return max;
    }
}
