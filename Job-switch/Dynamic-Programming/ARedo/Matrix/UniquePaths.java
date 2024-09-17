import java.security.PublicKey;
import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths1D(int m, int n) {
        int[] pre = new int[n];
        Arrays.fill(pre, 1);

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = j == 0 ? 1 : pre[j] + temp[j - 1];
            }
            pre = temp;
        }
        return pre[n - 1];
    }

    public int uniquePaths2D(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return rec(m, n, dp);
    }

    public int rec(int r, int c, int[][] dp) {

        if (r == 0 && c == 0)
            return 1;
        if (r < 0 || c < 0 || r >= dp.length || c >= dp[0].length)
            return 0;

        if (dp[r][c] != -1)
            return dp[r][c];

        int count = 0;
        count += rec(r - 1, c, dp);
        count += rec(r, c - 1, dp);
        return dp[r][c] =  count;
    }
}
