package SweepLine.Easy;

import java.util.Arrays;

public class CheckAllIntegersInRangeCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        if (ranges[0][0] > left || ranges[ranges.length - 1][1] < right)
            return false;

        int prevEnd = left - 1;

        for (int[] range : ranges) {
            int currStart = range[0];
            int currEnd = range[1];

            if (prevEnd < currStart - 1) {
                return false;
            }
            prevEnd = Math.max(currEnd, prevEnd);
            if (prevEnd >= right)
                break;
        }
        return true;
    }

    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            // Sort the ranges by starting point
            Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

            // Iterate through the ranges and check if all numbers from left to right are
            // covered
            for (int[] range : ranges) {
                // If the current range covers 'left', update 'left' to the end of the current
                // range +1
                if (range[0] <= left && range[1] >= left) {
                    left = range[1] + 1;
                }
                // If left goes beyond right, that means all numbers are covered
                if (left > right) {
                    return true;
                }
            }

            // If we exit the loop and left is still <= right, some numbers are not covered
            return left > right;
        }
    }

}
