package Random;

import java.util.Arrays;

public class MinFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, 101));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, helper(0, i, matrix, dp));
        }
        return min;
    }

    int colDir[] = { -1, 0, 1 };

    public int helper(int row, int col, int[][] matrix, int[][] dp) {
        if (row == matrix.length - 1)
            return matrix[row][col];

        if (dp[row][col] != 101)
            return dp[row][col];

        int curr = Integer.MAX_VALUE;
        for (int v : colDir) {
            int cc = col + v;
            if (cc >= 0 && cc < matrix.length) {
                curr = Math.min(helper(row + 1, cc, matrix, dp), curr);
            }
        }
        curr += matrix[row][col];
        return dp[row][col] = curr;
    }
}
