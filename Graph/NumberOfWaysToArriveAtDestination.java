package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
public class NumberOfWaysToArriveAtDestination {
    class Pair{
        int dest; int time;
        Pair(int des, int time){
            this.dest =des;
            this.time = time;
        }
    }
    class Stations{
        int node; int time; int numberOfWays;

        public Stations(int node, int time, int numberOfWays) {
            this.node = node;
            this.time = time;
            this.numberOfWays = numberOfWays;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = (int)Math.pow(10, 7);
        ArrayList<ArrayList<Pair>> adj = getAdjList(roads, n);

        int[] shortestArrivalTime = new int[n];
        Arrays.fill(shortestArrivalTime, Integer.MAX_VALUE);
        shortestArrivalTime[0] =0;

        int[] numberOfWays = new int[n];
        Arrays.fill(numberOfWays, 0);
        numberOfWays[0] = 1;

        PriorityQueue<Stations> pq = new PriorityQueue<>((a,b)-> a.time-b.time);
        pq.add(new Stations(0, 0, 1));

        int numberOfWaysToArrive = 0;
        while(!pq.isEmpty()){
            Stations st = pq.poll();
            for(Pair it: adj.get(st.node)){
                int timeToReach = it.time + st.time;
                if(timeToReach< shortestArrivalTime[it.dest]){
                    shortestArrivalTime[it.dest] = timeToReach;
                    pq.add(new Stations(it.dest, timeToReach, st.numberOfWays));
                } else if(timeToReach == shortestArrivalTime[it.dest]){
                    numberOfWays[it.dest] = (numberOfWays[it.dest] + st.numberOfWays)% mod;
                    pq.add(new Stations(it.dest, timeToReach, numberOfWays[it.dest]));
                }
            }
        }
        return numberOfWays[n-1] % mod;
    }

    private ArrayList<ArrayList<Pair>> getAdjList(int[][] roads, int n) {
        ArrayList<ArrayList<Pair>> ans = new ArrayList<>();
        for(int i =0; i<n; i++) ans.add(new ArrayList<>());
        for(int i= 0; i< roads.length; i++){
            ans.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            ans.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][2]));
        }
        return ans;
    }
}