package DSA.Graph.DisjointSet;
import java.io.*;
import java.util.*;

public class DisjointSet {

//    Finding the parent for a particular node (findPar())
//    Union (in broad terms this method basically adds an edge between two nodes): Union by rank, Union by size
    private ArrayList<Integer> rank = new ArrayList<>();
    private ArrayList<Integer> size = new ArrayList<>();
    private ArrayList<Integer> parent = new ArrayList<>();

    public ArrayList<Integer> getRank() {
        return rank;
    }

    public ArrayList<Integer> getSize() {
        return size;
    }

    public ArrayList<Integer> getParent() {
        return parent;
    }

    public DisjointSet(int n){
        for(int i =0; i<n; i++){
            rank.set(i, 0); // rank 0
            parent.set(i, i);
            size.set(i, 1); // with 1 otherwise sum always 0
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) return node;

        int parentN = findParent(parent.get(node));
        parent.set(node, parentN);
        return parent.get(node); // == parentN
    }

    public void unionByRank(int u, int v){
        if(v == u) return;
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(pu > pv) parent.set(pv, pu);
        else if(pu<pv) parent.set(pu, pv);
        else {
            parent.set(pu, pv);
            rank.set(v, rank.get(u)+1);
        }
    }
    public void unionBySize(int u, int v){
        if(v == u) return;
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(pu > pv){
            parent.set(pv, pu);
            size.set(u, size.get(v)+size.get(v));
        } else {
            parent.set(pu, pv);
            size.set(v, size.get(v)+size.get(v));
        }
    }
}
