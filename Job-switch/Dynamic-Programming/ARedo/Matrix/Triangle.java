import java.util.Arrays;

public class Triangle {

    public static int minimumPathSum(int[][] triangle, int x) {
        int m = triangle.length;
        int[][] dp = new int[m][];
        dp[0] = new int[] { triangle[0][0] }; // Initialize the first row of dp

        for (int row = 1; row < m; row++) {
            int cols = row + 1;
            dp[row] = new int[cols]; // Initialize each row with row + 1 elements

            for (int c = 0; c < cols; c++) {
                dp[row][c] = triangle[row][c] + dp[row - 1][c];

                // If c > 0, take the minimum from the previous row's c or c-1 position
                if (c > 0) {
                    dp[row][c] = Math.min(dp[row][c], triangle[row][c] + dp[row - 1][c - 1]);
                }
            }
        }

        // The last row contains the possible path sums, find the minimum
        int min = Arrays.stream(dp[m - 1]).min().orElse(Integer.MAX_VALUE);
        return min;
    }

    public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
        int pre[] = matrix[0].clone();
        int n = matrix[0].length;
        for (int row = 1; row < matrix.length; row++) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                int topLeft = i == 0 ? 0 : pre[i - 1];
                int top = pre[i];
                int topRight = i == n - 1 ? 0 : pre[i + 1];
                int tempMax = Math.max(top, Math.max(topLeft, topRight));
                temp[i] = matrix[row][i] + tempMax;
            }
            pre = temp;
        }

        return Arrays.stream(pre).max().orElse(Integer.MIN_VALUE);
	}
}
