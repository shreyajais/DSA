package DSA.DynamicPrograming.Square;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp= new int[m][n];
        for(int i =0; i<n; i++){
            if(matrix[0][i]== '1') dp[0][i] = 1;
        }

    }
}
