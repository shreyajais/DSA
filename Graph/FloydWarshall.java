package DSA.Graph;

public class FloydWarshall {


//User function template for JAVA
    // shorted path => Math.min(direct, inderect from any other node from all the nodes)
public void shortest_distance(int[][] matrix)
{
    for(int i =0; i<matrix.length; i++){
        for(int j =0; j<matrix[0].length; j++){
            if(matrix[i][j]== -1) matrix[i][j] = (int)10e8;
        }
    }

    for(int k =0; k< matrix.length; k++){
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                if(matrix[i][k] != (int)10e8 || matrix[k][j] != (int)10e8)
                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
            }
        }
    }

    for(int i =0; i<matrix.length; i++){
        for(int j =0; j<matrix[0].length; j++){
            if(matrix[i][j]== (int)10e8) matrix[i][j] = -1;
        }
    }
}
}
