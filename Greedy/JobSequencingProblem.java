package DSA.Greedy;

import java.util.Arrays;

public class JobSequencingProblem {
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> b.profit-a.profit);
        int[] time = new int[n+1];
        Arrays.fill(time, -1);
        int count = 0, profitSoFar = 0;
        for(int i =0; i<n; i++){
            int j = arr[i].deadline;
            while(j>0){ // as each job take i unit time we have time as deadline array from 1 to n+1
                if(time[j] == -1){
                    time[j] = arr[i].id;
                    profitSoFar += arr[i].profit;
                    count++;
                    break;
                }
                j--;
            }
        }
        int[] ans = new int[2];
        ans[0] = count; ans[1] = profitSoFar;
        return ans;
    }
}
