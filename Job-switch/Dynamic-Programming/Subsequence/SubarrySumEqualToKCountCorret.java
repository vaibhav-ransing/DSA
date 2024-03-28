package Subsequence;

import java.util.Arrays;

public class SubarrySumEqualToKCountCorret {
    static int MOD = 1000000007;

    public static int util(int[] arr, int i, int sum, int[][] dp) {
        if (i < 0) {
            return (sum == 0) ? 1 : 0;
        }
        if (sum < 0) {
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int choose = util(arr, i - 1, sum - arr[i], dp);
        int skip = util(arr, i - 1, sum, dp);
        return dp[i][sum] = ((choose + skip)% MOD );
    }

    public static int findWays(int[] arr, int k) {
        int[][] dp = new int[arr.length][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = util(arr, arr.length - 1, k, dp);
        return ans;
    }
}
