package SweepLine.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEventsAttended {

    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int prevEnd = events[0][1];
        int count = 1;
        int max = 0;
        for (int i = 1; i < events.length; i++) {
            int curr[] = events[i];
            if (curr[0] > prevEnd) {
                count = 1;
                prevEnd = curr[1];
            } else {
                count++;
                prevEnd = Math.max(prevEnd, curr[1]);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    class Solution {
        public int maxEvents(int[][] events) {
            // Sort events by their start day
            Arrays.sort(events, (a, b) -> a[0] - b[0]);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int maxEvents = 0;
            int day = 0;
            int i = 0;
            int n = events.length;

            // Process events day by day
            while (!pq.isEmpty() || i < n) {
                // If the queue is empty, jump to the next event's start day
                if (pq.isEmpty()) {
                    day = events[i][0];
                }

                // Add all events that start on this day to the priority queue
                while (i < n && events[i][0] <= day) {
                    pq.add(events[i][1]);
                    i++;
                }

                // Attend the event that ends the earliest
                pq.poll();
                maxEvents++;
                day++;

                // Remove events that have already ended
                while (!pq.isEmpty() && pq.peek() < day) {
                    pq.poll();
                }
            }

            return maxEvents;
        }
    }

}
