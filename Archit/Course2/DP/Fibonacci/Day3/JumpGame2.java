package DP.Day3;

import java.util.Arrays;

public class JumpGame2 {

    public int dpMemo(int idx, int[] nums, int[] dp) {
        if (idx >= nums.length)
            return (int) 1e7;
        if (idx == nums.length - 1)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int ans = (int) 1e7;
        for (int jump = 1; jump <= nums[idx]; jump++) {
            int val = dpMemo(idx + jump, nums, dp);
            ans = Math.min(ans, val + 1);
        }
        return dp[idx] = ans;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int val = dpMemo(0, nums, dp);
        return val;
    }

}
