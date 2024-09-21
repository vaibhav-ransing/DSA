import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return rec(0, target, nums, dp);
    }

    public int rec(int idx, int sum, int[] nums, int[][] dp) {
        if (idx == nums.length && sum == 0) {
            return 1;
        }
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][sum] != -1)
            return dp[idx][sum];
        int count = 0;
        count += rec(idx + 1, sum - nums[idx], nums, dp);
        count += rec(idx + 1, sum + nums[idx], nums, dp);

        return dp[idx][sum] = count;
    }


}
