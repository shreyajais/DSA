package DSA.BinarySearch.TwoD;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int val = matrix[getRow(mid, n)][getCol(mid, n)];
            if(val == target) return true;
            else if(val < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }

    private int getCol(int index, int noOfCol) {
        return index%noOfCol;
    }

    private int getRow(int index, int noOfCol) {
        return index/noOfCol;
    }
}
