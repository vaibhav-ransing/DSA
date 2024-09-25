package SweepLine.Medium;

import java.util.Arrays;

public class MaxSumObtainedAnyPermutation {

    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] arr = new int[5];
        int start = 100001;
        for (int[] req : requests) {
            arr[req[0] + 1]++;
            arr[req[1] + 1]--;
            start = Math.min(start, req[0] + 1);
        }
        for (int i = start; i < nums.length; i++) {
            arr[i] += arr[i - 1];
        }
        int[] freq = Arrays.copyOf(arr, nums.length);
        Arrays.sort(nums);
        Arrays.sort(freq);

        for (int i = 0; i < nums.length; i++) {

        }

        int ans = 0;

        return ans;
    }

    class Solution {
        public int maxSumRangeQuery(int[] nums, int[][] requests) {
            int MOD = 1000000007;
            int n = nums.length;
            int[] freq = new int[n + 1];

            // Process each request to build the freq array
            for (int[] request : requests) {
                int start = request[0];
                int end = request[1];
                freq[start]++;
                if (end + 1 < n) {
                    freq[end + 1]--;
                }
            }

            // Convert freq array to actual counts using prefix sum
            for (int i = 1; i < n; i++) {
                freq[i] += freq[i - 1];
            }
            Arrays.sort(freq);
            // Remove the extra element we added at the end
            freq = Arrays.copyOf(freq, n);

            // Sort the nums array and freq array
            Arrays.sort(nums);
            Arrays.sort(freq);

            // Calculate the maximum sum by pairing largest elements with highest
            // frequencies
            long maxSum = 0;
            for (int i = 0; i < n; i++) {
                maxSum = (maxSum + (long) nums[i] * freq[i]) % MOD;
            }

            return (int) maxSum;
        }
    }

}
