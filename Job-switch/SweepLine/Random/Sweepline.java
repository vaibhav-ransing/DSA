package SweepLine.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Event {
    int time;
    boolean isStart;

    public Event(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
}

public class Sweepline {
    public static int findMaxOverlappingIntervals(List<int[]> intervals) {
        List<Event> events = new ArrayList<>();

        // Convert each interval to two events
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], true)); // Start of an interval
            events.add(new Event(interval[1], false)); // End of an interval
        }

        // Sort events: first by time, then by type (start before end if same time)
        Collections.sort(events, new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                if (e1.time != e2.time) {
                    return e1.time - e2.time;
                }
                return e1.isStart ? -1 : 1;
            }
        });

        int maxOverlap = 0;
        int currentOverlap = 0;

        // Sweep through the events
        for (Event event : events) {
            if (event.isStart) {
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
            } else {
                currentOverlap--;
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        // Example intervals: [1, 3], [2, 5], [4, 6]
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[] { 1, 3 });
        intervals.add(new int[] { 2, 5 });
        intervals.add(new int[] { 4, 6 });

        int maxOverlap = findMaxOverlappingIntervals(intervals);
        System.out.println("Maximum number of overlapping intervals: " + maxOverlap);
    }
}
