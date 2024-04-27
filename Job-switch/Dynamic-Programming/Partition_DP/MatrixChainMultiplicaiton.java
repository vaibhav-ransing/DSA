package Partition_DP;

import java.util.Arrays;

public class MatrixChainMultiplicaiton {

    public static int minScoreTriangulation(int[] values) {
        int N = values.length;
        int dp[][] = new int[N][N];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(1, values.length - 1, values, dp);
    }

    // 10, 20, 30, 40, 50
    // A B C D

    public static int recursion(int i, int j, int[] values, int dp[][]) {
        if (i == j)
            return 0;
        int ans = Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k < j; k++) {
            int left = recursion(i, k, values, dp);
            int right = recursion(k + 1, j, values, dp);
            int steps = left + right + (values[i - 1] * values[k] * values[j]);

            ans = Math.min(ans, steps);
        }
        return dp[i][j] = ans;
    }

    public static int tabulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];

        for (int i = n - 1; i > 0; i--) { // smaller problem is at n-1 and we increase till 0
            for (int j = i + 1; j < n; j++) { // j is always at right to i, so i+1 to n-1
                int ans = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int left = dp[i][k];
                    int right = dp[k + 1][j];
                    int steps = left + right + (values[i - 1] * values[k] * values[j]);
                    ans = Math.min(ans, steps);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {

    }
}