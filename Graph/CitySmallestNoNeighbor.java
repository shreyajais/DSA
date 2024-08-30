package DSA.Graph;

public class CitySmallestNoNeighbor {
  // // distance from all the nodes from all the node --> floyd
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] matrixDist = new int[n][n];
      for(int i =0; i<n; i++){
          for(int j =0; j<n; j++){
              if(i==j) matrixDist[i][j] = 0;
              else matrixDist[i][j] = (int)10e8;
          }
      }

      for(int i =0; i<edges.length; i++){
          int u = edges[i][0], v = edges[i][1], wt = edges[i][2];
          matrixDist[u][v] = wt; matrixDist[v][u] = wt;
      }

      for(int k =0; k< n; k++){
          for(int i =0; i<n; i++){
              for(int j =0; j<n; j++){
                  if(i==j) matrixDist[i][j] = 0;
                  else {
                      if(matrixDist[i][k] != (int)10e8 || matrixDist[k][j] != (int)10e8)
                          matrixDist[i][j] = Math.min(matrixDist[i][j], matrixDist[i][k] + matrixDist[k][j]);
                  }
              }
          }
      }
      int reachableCities = n;
      int minNeigbourCity = -1;
      for(int i =0; i<n; i++){
          int count = 0;
          for(int j =0; j<n; j++){
             if(matrixDist[i][j] <= distanceThreshold) count++;
          }
          if(count<reachableCities){
              reachableCities = count;
              minNeigbourCity = i;
          }
      }
      return minNeigbourCity;
  }


}
