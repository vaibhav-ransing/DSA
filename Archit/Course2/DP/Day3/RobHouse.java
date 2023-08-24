package DP.Day3;

public class RobHouse {

    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return dpMemo(nums, 0, false, dp);
    }

    public int rec(int[] nums, int idx, boolean prevRob) {
        if (idx >= nums.length)
            return 0;

        int dontRob = rec(nums, idx + 1, false);
        int rob = prevRob == false ? nums[idx] + rec(nums, idx + 1, true) : dontRob;

        return Math.max(dontRob, rob);
    }

    public int dpMemo(int[] nums, int idx, boolean prevRob, int[][] dp) {
        if (idx >= nums.length)
            return 0;

        int row = prevRob ? 0 : 1;
        if(dp[row][idx] != -1) return dp[row][idx];

        int dontRob = dpMemo(nums, idx + 1, false, dp);
        int rob = prevRob == false ? nums[idx] + dpMemo(nums, idx + 1, true, dp) : dontRob;

        return  dp[row][idx] =  Math.max(dontRob, rob);
    }
}
