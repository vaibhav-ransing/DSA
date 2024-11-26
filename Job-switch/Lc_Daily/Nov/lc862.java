package Lc_Daily.Nov;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc862 {

    public int shortestSubarray(int[] arr, int val) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (left <= right && (sum >= val || sum - arr[left] >= val)) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Use long to handle potential overflow with sums
        long[] prefixSum = new long[n + 1];

        // Calculate prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Initialize result to handle case when no valid subarray is found
        int result = n + 1;

        // Use deque to maintain a monotonic increasing sequence of prefix sums
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Remove elements from the back of deque that are greater than current prefix sum
            // This maintains monotonic increasing property
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Check if we can find a valid subarray ending at current position
            while (!deque.isEmpty() && prefixSum[i] >= prefixSum[deque.peekFirst()] + k) {
                result = Math.min(result, i - deque.pollFirst());
            }

            deque.addLast(i);
        }

        return result <= n ? result : -1;
    }
}