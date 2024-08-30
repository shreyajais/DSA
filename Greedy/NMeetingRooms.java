package DSA.Greedy;

import java.util.Arrays;

public class NMeetingRooms {
    class Meeting implements Comparable<Meeting>{
        int startTime; int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.endTime - o.endTime;
        }
    }
    public int maxMeetings(int n, int start[], int end[]) {
        Meeting[] meetings = new Meeting[n];
        for(int i =0; i<n; i++) meetings[i] = new Meeting(start[i],end[i]);
        Arrays.sort(meetings);
        int endSoFar = 0, count = 0;
        for(int i =0; i<meetings.length; i++){
            if(meetings[i].startTime>endSoFar){
                count++;
                endSoFar = meetings[i].endTime;
            }
        }
        return count;
    }
}
