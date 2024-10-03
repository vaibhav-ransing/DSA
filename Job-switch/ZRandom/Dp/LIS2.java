package ZRandom.Dp;

public class LIS2 {

    public int lengthOfLIS(int[] nums, int k) {
        return rec(0, -1, nums, k);
    }

    int rec(int idx, int prev_idx, int[] nums, int k) {
        if (idx == nums.length)
            return 0;
        int skip = rec(idx + 1, prev_idx, nums, k);
        int take = 0;
        if (prev_idx == -1 || (nums[prev_idx] < nums[idx] && nums[prev_idx] + k + 1 > nums[idx])) {
            take = 1 + rec(idx + 1, idx, nums, k);
        }
        return Math.max(take, skip);
    }
}
