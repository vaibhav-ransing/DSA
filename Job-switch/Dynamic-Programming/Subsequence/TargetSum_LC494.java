package Subsequence;

import java.util.Arrays;

public class TargetSum_LC494 {

    public int findTargetSumWays(int[] arr, int diff) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        int[][][] dp = new int[n][sum + 1][sum + 1];
        for (int idp[][] : dp) {
            for (int d[] : idp) {
                Arrays.fill(d, -1);
            }
        }
        return recursion(arr, 0, 0, n - 1, diff, dp);
    }

    public static int recursion(int[] arr, int p1, int p2, int idx, int diff, int[][][] dp) {
        if (idx < 0)
            return (p1 - p2) == diff ? 1 : 0;
        if (dp[idx][p1][p2] != -1)
            return dp[idx][p1][p2];
        int take1 = recursion(arr, p1 + arr[idx], p2, idx - 1, diff, dp);
        int take2 = recursion(arr, p1, p2 + arr[idx], idx - 1, diff, dp);

        return dp[idx][p1][p2] = take1 + take2;
    }

}
