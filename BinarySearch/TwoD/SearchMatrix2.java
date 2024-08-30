package DSA.BinarySearch.TwoD;

public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowI = 0, colI = matrix[0].length-1;
        while(rowI>=0 && rowI< matrix.length && colI>=0 && colI<matrix[0].length){
            int midValue = matrix[rowI][colI];
            if(target == midValue) return true;
            else if(target<midValue) colI--;
            else rowI++;
        }
        return false;
    }
}
