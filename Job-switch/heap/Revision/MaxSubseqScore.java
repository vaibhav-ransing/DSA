package Revision;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubseqScore {

    // Similar Questions:
        // https://leetcode.com/problems/maximum-performance-of-a-team/description/
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];
            if (pq.size() < k)
                continue;
            ans = Math.max(ans, sum * arr[i][1]);
            sum -= pq.remove();
        }
        return ans;
    }
}