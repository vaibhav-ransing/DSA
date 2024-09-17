import java.util.Arrays;

public class UniquePaths2 {

    public int uniquePathsWithObstacles1(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return rec(mat.length - 1, mat[0].length - 1, mat, dp);
    }

    public int rec(int r, int c, int[][] mat, int[][] dp) {
        if (r < 0 || c < 0 || mat[r][c] == 1)
            return 0;
        if (r == 0 && c == 0)
            return 1;
        if (dp[r][c] != -1)
            return dp[r][c];
        int count = 0;
        count += rec(r - 1, c, mat, dp);
        count += rec(r, c - 1, mat, dp);
        return dp[r][c] = count;
    }

    public int uniquePathsWithObstacles(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (mat[0][i] == 1)
                break; // Stop when encountering an obstacle
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 1)
                break; // Stop when encountering an obstacle
            dp[i][0] = 1;
        }

        // Fill the dp array
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (mat[row][col] == 1) {
                    dp[row][col] = 0; // If blocked, no path can pass through
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
