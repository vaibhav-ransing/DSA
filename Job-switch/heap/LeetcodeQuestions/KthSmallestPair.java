package LeetcodeQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPair {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // i, j, diff
        pq.add(new int[] { 0, 1, nums[1] - nums[2] });
        while (k > 1 && pq.size() > 0) {
            int[] peek = pq.remove();
            int i = peek[0];
            int j = peek[1];
            int diff = peek[2];
            System.out.println(i + " " + j + " " + diff);
            if (j + 1 < nums.length) {
                System.out.println((nums[j + 1] - nums[i] )+ " | j + 1, j" + (nums[j + 1] - nums[j]));
                pq.add(new int[] { i, j + 1, nums[j + 1] - nums[i] });
                pq.add(new int[] { j, j + 1, nums[j + 1] - nums[j] });
            }
            if (i + 1 != j)
                pq.add(new int[] { i + 1, j, nums[j] - nums[i + 1] });
        }
        return pq.peek()[2];
    }

}
