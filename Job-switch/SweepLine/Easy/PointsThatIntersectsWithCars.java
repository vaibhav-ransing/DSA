package SweepLine.Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PointsThatIntersectsWithCars {

    public int numberOfPointsLineSweep(List<List<Integer>> nums) {
        Collections.sort(nums, (a, b) -> a.get(0) - b.get(0));
        int start = nums.get(0).get(0);
        int end = nums.get(0).get(1);
        System.out.println(start + " " + end);
        System.out.println();
        int count = 0;
        for (int i = 1; i < nums.size(); i++) {
            int currStart = nums.get(0).get(0);
            int currEnd = nums.get(0).get(1);
            System.out.println(currStart + " " + currEnd);
            if (currStart > end) {
                count += end - start;
                start = currStart;
                end = currEnd;
            } else {
                end = Math.max(end, currEnd);
            }
            System.out.println(currStart + " " + currEnd);
            System.out.println("-------");
        }
        count += end - start;
        return count;
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] arr = new int[101];
        for (List<Integer> num : nums) {
            arr[num.get(0)]++;
            arr[num.get(1)]--;
        }
        System.out.println(nums);
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }

}
