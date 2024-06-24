package Subarray;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Lc1438AbosluteDiffLessThanLimit {

    public int longestSubarray(int[] arr, int limit) {
        int i = 0, j = 0;
        int n = arr.length;

        int dp[] = new int[n];

        PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // val, idx
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // val, idx

        minPq.add(new int[] { arr[0], 0 });
        maxPq.add(new int[] { arr[0], 0 });

        while (j < n) {
            int cv = arr[j];
            
        }
    }

}