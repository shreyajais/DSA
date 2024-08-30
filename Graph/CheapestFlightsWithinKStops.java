package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    class Pair{
        int dest; int price;
        Pair(int dest, int price){
            this.dest = dest;
            this.price = price;
        }
    }
    class Route{
        int dest;
        int priceSoFar;
        int stopsSoFar;
        Route(int dest, int priceSoFar, int stopsSoFar){
            this.dest = dest;
            this.priceSoFar = priceSoFar;
            this.stopsSoFar = stopsSoFar;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;
        ArrayList<ArrayList<Pair>> adj = getAdjList(flights, n);
        int[] totalPrice = new int[n];
        Arrays.fill(totalPrice, Integer.MAX_VALUE);
        Queue<Route> q = new LinkedList<>();
        q.add(new Route(src, 0, 0));
        totalPrice[src] = 0;

        while(!q.isEmpty()){
            Route r = q.poll();
            if(r.stopsSoFar<= k){ //  if(stops > K) continue;
                for(Pair it: adj.get(r.dest)){
                    if(totalPrice[it.dest]> r.priceSoFar + it.price){ //stops <= K
                        totalPrice[it.dest] = r.priceSoFar + it.price;
                        q.add(new Route(it.dest, totalPrice[it.dest],  r.stopsSoFar+1));
                    }
                }
            }
        }
        return totalPrice[dst]==Integer.MAX_VALUE ? -1: totalPrice[dst];

    }

    private ArrayList<ArrayList<Pair>> getAdjList(int[][] flights, int n) {
        ArrayList<ArrayList<Pair>> ans = new ArrayList<>();
        for(int i =0; i<n; i++) ans.add(new ArrayList<>());
        for(int i =0; i<flights.length; i++){
            ans.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        return  ans;
    }
}

