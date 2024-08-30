package DSA.Graph.DisjointSet;

import DSA.Graph.DisjointSet.DisjointSet;

public class NumberOperationNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds  = new DisjointSet(n);
        int extraConnections = 0;
        for(int i =0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findParent(u) == ds.findParent(v)) extraConnections++;
            else ds.unionByRank(u, v);
        }
        // counting critical nodes == number of independent islands or group
        int countGroup = 0;
        for(int i =0; i<n; i++){
            if(ds.findParent(i) == i) countGroup++;
        }
        // number Of Edges Req To Join Independent Groups
        int numberOfEdgesReqToJoinGroup = countGroup -1;
        // is extra connections sufficient to rearrange and make them critical connections
        if(extraConnections>=numberOfEdgesReqToJoinGroup) return numberOfEdgesReqToJoinGroup;
        return -1;
    }
}
