package Subsequence;

import java.util.Arrays;

// Given a target find all possible ways th
public class SubarraySumEqualToKCount {

    public static int findWays(int[] nums, int tar) {
        int[][] dp = new int[nums.length][tar + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return recursion(nums.length - 1, tar, nums, dp);
    }

    static int MOD = 1000000007;
    public static int recursion(int idx, int tar, int[] nums, int[][] dp) {
        if (tar < 0)
            return 0;

        if (idx < 0 || tar == 0)
            return tar == 0 ? 1 : 0;

        if (dp[idx][tar] != -1)
            return dp[idx][tar];
        int take = recursion(idx - 1, tar - nums[idx], nums, dp);
        int dontTake = recursion(idx - 1, tar, nums, dp);
        return dp[idx][tar] = (take + dontTake)%MOD;
    }

    public static int subarraySumTab(int[] nums, int tar) {
        int n = nums.length;
        int[][] dp = new int[n + 1][tar + 1];

        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // Empty subset is always a valid subset with sum 0
        }

        // Build dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= tar; j++) {
                if (j < nums[i - 1]) {
                    // If the current element is greater than the target sum, we can't include it
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, we have two choices: include the current element or exclude it
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][tar];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1,2,1};
        int tar = 3;
        // int arr[] = { 1, 1, 4, 5 };
        // int arr[] = { 3, 5, 6, 7 };
        // int tar = 9;

        System.out.println(findWays(arr, tar));

    }
}
