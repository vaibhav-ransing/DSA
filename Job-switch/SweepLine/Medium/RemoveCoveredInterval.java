package SweepLine.Medium;

import java.util.Arrays;

public class RemoveCoveredInterval {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int prevEnd = -1;
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart > prevEnd || currEnd > prevEnd) {
                count++;
            }
            prevEnd = Math.max(prevEnd, currEnd);
        }
        return count;
    }

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
           Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0])); 
    
           int ans = 0, end = 0;
           for(int[] interval : intervals) {
               if(interval[1] <= end) continue;
               end = interval[1];
               ans++;
           }
    
           return ans;
        }
    }
}
