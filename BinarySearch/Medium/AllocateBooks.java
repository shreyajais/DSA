package DSA.BinarySearch.Medium;

import java.util.ArrayList;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;
        if(m==n) return getMaxPages(arr, n);
        int low = getMaxPages(arr, n);
        int high = getSumOfAllPages(arr, n);
        while(low<=high){
            int mid = (low+high)/2;
            if(canReadBook(arr, n, m, mid)) low = mid+1;
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
    //You have to allocate the book to ‘m’ students 'n' books such that the maximum number of pages assigned to a student is minimum.
    // one student multiple books but atleast one book.
    // one book to one student
}
