package DP.Day3;

public class RobHouseCircular {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(tabulation(nums, 0, n - 2),
                tabulation(nums, 1, n - 1));
    }

    public int tabulation(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 5];
        for (int idx = end; idx >= start; idx--) {
            dp[idx] = Math.max(dp[idx + 2] + nums[idx], dp[idx + 1] );
        }

        return dp[start];
    }

}
