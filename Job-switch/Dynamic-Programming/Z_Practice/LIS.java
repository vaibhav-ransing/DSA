import java.util.Arrays;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(0, -1, nums, dp);
    }

    public int helper(int idx, int prev_idx, int[] nums, int[][] dp) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][prev_idx + 1] != -1)
            return dp[idx][prev_idx + 1];

        int skip = helper(idx + 1, prev_idx, nums, dp);
        int take = 0;
        if (prev_idx == -1 || nums[prev_idx] < nums[idx]) {
            take = 1 + helper(idx + 1, idx, nums, dp);
        }
        return dp[idx][prev_idx + 1] = Math.max(take, skip);
    }

    public int lisTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {
                int skip = dp[idx + 1][prev_idx + 1];
                int take = 0;
                if (prev_idx == -1 || nums[prev_idx] < nums[idx]) {
                    take = 1 + dp[idx + 1][idx];
                }
                dp[idx][prev_idx + 1] = Math.max(take, skip);
            }
        }
        return dp[0][0];
    }
}
