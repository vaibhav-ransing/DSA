package Revision;

import java.util.Arrays;

public class SuperEggDrop {
    class SolutionBS {
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k + 1][n + 1];
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
            return findMinTrials(k, n, dp);
        }

        private int findMinTrials(int k, int n, int[][] dp) {
            if (n == 0 || n == 1)
                return n;
            if (k == 1)
                return n;
            if (dp[k][n] != -1)
                return dp[k][n];
            int res = (int) 1e9;
            int low = 1, high = n;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int down = findMinTrials(k - 1, mid - 1, dp);
                int up = findMinTrials(k, n - mid, dp);
                res = Math.min(res, 1 + Math.max(up, down));

                if (down < up)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return dp[k][n] = res;
        }
    }

    class Solution {

        private int[][] memo;

        public int superEggDrop(int k, int n) {
            memo = new int[k + 1][n + 1];

            // O(n * k) * O(n) -> O(n^2 * k)
            return rec(k, n);
        }

        // O(n * k) (states)
        public int rec(int eggs, int floors) {
            // Base cases
            if (eggs == 1 || floors == 0 || floors == 1) {
                return floors;
            }

            // Check if result is already computed
            if (memo[eggs][floors] != 0) {
                return memo[eggs][floors];
            }

            int min = Integer.MAX_VALUE;
            // O(n)
            for (int k = 1; k <= floors; k++) {
                int breaks = 1 + rec(eggs - 1, k - 1);
                int notBreak = 1 + rec(eggs, floors - k);
                min = Math.min(min, Math.max(breaks, notBreak));
            }

            // Store the result in the memoization table
            memo[eggs][floors] = min;

            return min;
        }

    }
}
