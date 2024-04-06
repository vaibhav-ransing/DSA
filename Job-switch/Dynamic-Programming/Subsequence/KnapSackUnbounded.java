package Subsequence;

import java.util.Arrays;

public class KnapSackUnbounded {

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int dp[][] = new int[n][w + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        int ans = recursion(n - 1, w, profit, weight, dp);
        return ans < 0 ? 0 : ans;
    }

    public static int recursion(int idx, int w, int[] profit, int[] weight, int dp[][]) {

        if (idx < 0 || w == 0)
            return w == 0 ? 0 : Integer.MIN_VALUE;

        if (w < 0)
            return Integer.MIN_VALUE;

        if (dp[idx][w] != -1)
            return dp[idx][w];
        int skip = recursion(idx - 1, w, profit, weight, dp);
        int take = recursion(idx, w - weight[idx], profit, weight, dp) + profit[idx];

        return dp[idx][w] = Math.max(skip, take);
    }

    public void tabulation(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int skip = dp[i - 1][j];
                int take = 0;
                if (j - weight[i - 1] >= 0) {
                    take = dp[i][j - weight[i - 1]] + profit[i - 1];
                }
                dp[i][j] = Math.max(take, skip);
            }
        }
        // return dp[dp.length-1][dp[0].length-1];
    }
}