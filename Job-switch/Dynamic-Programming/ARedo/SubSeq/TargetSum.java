import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return rec(0, target, nums);
    }

    public int rec(int idx, int sum, int[] nums) {
        if (idx == nums.length && sum == 0) {
            return 1;
        }
        if (idx == nums.length) {
            return 0;
        }

        int count = 0;
        count += rec(idx + 1, sum - nums[idx], nums);
        count += rec(idx + 1, sum + nums[idx], nums);

        return count;
    }

    public int tabulation(int[] nums, int target) {

        int[][] dop
    }

}
