package DSA.BinarySearch.Hard;

public class KthElement {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        if((n1 + n2)<k) return -1;
        if((n1+n2) == k) return Math.max(arr1[n1-1], arr2[n2-1]);
        if(n1>n2) return kthElement(k, arr1, arr2);
        int leftHalfLength = k;
        // low, mid , high are the index
        // low1 = 0 means all the elements of nums1 lies in right half
        // high1 = n1 means all the elements of nums1 lies in left half.
        int low1 = Math.max(0, k - n2), high1 = Math.min(k, n1);
        while(low1<=high1){
            int mid1 = (low1+high1)/2;
            int mid2 = leftHalfLength-mid1;
            int l1 = mid1==0 ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = mid2==0 ? Integer.MIN_VALUE: arr2[mid2-1];
            int r1 = mid1==n1 ? Integer.MAX_VALUE: arr1[mid1];
            int r2 = mid2==n2 ? Integer.MAX_VALUE: arr2[mid2];
            if(l1<=r2 && l2<=r1) return Math.max(l1, l2);
            else if(l1>r2) high1 = mid1-1;
            else low1 = mid1+1;
        }
        return -1;
    }
}
