package SweepLine.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveIntervals {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = toBeRemoved[0];
        int right = toBeRemoved[1];
        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            if (currEnd < left || currStart > right) {
                ans.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
            } else if (left > currStart && right < currEnd) {
                ans.add(new ArrayList<>(Arrays.asList(currStart, left - 1)));
                ans.add(new ArrayList<>(Arrays.asList(right + 1, currEnd)));
            }
        }
        return ans;
    }

    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            int start = toBeRemoved[0];
            int end = toBeRemoved[1];
            List<List<Integer>> remaining = new ArrayList<>();
            for (int[] e : intervals) {
                if (e[0] < start) {
                    remaining.add(List.of(e[0], Math.min(e[1], start)));
                }
                if (e[1] > end) {
                    remaining.add(List.of(Math.max(e[0], end), e[1]));
                }
            }
            return remaining;
        }
    }

}
