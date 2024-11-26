package AALastGo.Sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingScheduler {

    class TreeMapSoltuion {

        public List<Integer> earliestAppropriateDuration(int[][] slots1, int[][] slots2, int duration) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            // Populate the TreeMap with start and end times
            for (int[] slot : slots1) {
                map.put(slot[0], map.getOrDefault(slot[0], 0) + 1);
                map.put(slot[1], map.getOrDefault(slot[1], 0) - 1);
            }
            for (int[] slot : slots2) {
                map.put(slot[0], map.getOrDefault(slot[0], 0) + 1);
                map.put(slot[1], map.getOrDefault(slot[1], 0) - 1);
            }

            int count = 0;
            Integer previous = null; // Tracks the last timestamp when count reached 2

            // Traverse the TreeMap to find the earliest appropriate duration
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int time = entry.getKey();
                count += entry.getValue();

                if (count == 2 && previous == null) {
                    // Start tracking when overlapping slots begin
                    previous = time;
                } else if (count < 2 && previous != null) {
                    // Check if the overlapping duration is sufficient
                    if (time - previous >= duration) {
                        return Arrays.asList(previous, previous + duration);
                    }
                    previous = null; // Reset if duration is insufficient
                }
            }

            return new ArrayList<>(); // Return empty list if no valid slot is found
        }

    }

    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
            Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

            int i = 0, j = 0;

            while (i < slots1.length && j < slots2.length) {

                int start = Math.max(slots1[i][0], slots2[j][0]);
                int end = Math.min(slots1[i][1], slots2[j][1]);

                // Check if the intersection is at least `duration`
                if (end - start >= duration) {
                    ans.add(start);
                    ans.add(start + duration);
                    return ans; // Found the minimum duration, return immediately
                }

                // Move the pointer of the interval that ends earlier
                if (slots1[i][1] < slots2[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
            return ans; // Return empty if no valid duration is found
        }
    }
}