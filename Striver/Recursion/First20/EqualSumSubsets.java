package First20;

public class EqualSumSubsets {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        int[][] dp = new int[sum][sum];

        return helper(nums, 0, 0, 0);
    }

    public boolean helper(int[] nums, int idx, int sum1, int sum2) {
        if (idx == nums.length) {
            return sum1 == sum2;
        }
        helper(nums, idx + 1, sum1 + nums[idx], sum2);
        helper(nums, idx + 1, sum1, sum2 + nums[idx]);

        return true;
    }

}