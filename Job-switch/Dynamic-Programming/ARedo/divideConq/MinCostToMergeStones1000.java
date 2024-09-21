import java.util.Arrays;

public class MinCostToMergeStones1000 {

    class Solution {
        public int mergeStones(int[] stones, int k) {
            if ((stones.length - 1) % (k - 1) != 0)
                return -1;

            int[][] dp = new int[stones.length + 1][stones.length + 1];
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }
            return helper(stones, 0, stones.length - 1, k, dp);
        }

        public int helper(int[] stones, int i, int j, int k, int[][] dp) {
            if (i >= j)
                return 0;

            if (dp[i][j] != -1)
                return dp[i][j];
            int min = Integer.MAX_VALUE;
            for (int idx = i; idx < j; idx += k - 1) {
                int ans = helper(stones, i, idx, k, dp) + helper(stones, idx + 1, j, k, dp);
                min = Math.min(ans, min);
            }
            if (min != Integer.MAX_VALUE && ((j - i) % (k - 1)) == 0) {
                for (int n = i; n <= j; n++) {
                    min += stones[n];
                }
            }
            return dp[i][j] = min;
        }
    }
}
