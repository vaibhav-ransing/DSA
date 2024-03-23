import java.util.Arrays;

public class GitdMinPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int ans = recursion(m - 1, n - 1, dp, grid);
        for (int[] row : dp)
            System.out.println(Arrays.toString(row));
        System.out.println(ans);
        return ans;
    }

    public static int recursion(int row, int col, int[][] dp, int[][] grid) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || row == dp.length || col < 0 || col == dp[0].length)
            return Integer.MAX_VALUE;
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int left = recursion(row, col - 1, dp, grid);
        int up = recursion(row - 1, col, dp, grid);
        int min = Math.min(left, up);

        return dp[row][col] = grid[row][col] + min;
    }

    public static int tabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int prev[] = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            prev[i] = i == n - 1 ? grid[m - 1][i] : prev[i + 1] + grid[m - 1][i];
        }
        for (int row = m - 2; row >= 0; row--) {
            int temp[] = new int[n];
            temp[n-1] = prev[n-1] + grid[row][n-1];


            for (int i = n - 2; i >= 0; i--) {
                int min = grid[row][i] + Math.min(temp[i + 1], prev[i]);
                temp[i] = min;
            }
            System.out.println(Arrays.toString(prev));
            System.out.println(Arrays.toString(temp));
            System.out.println();
            prev = temp;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 } };
        tabulation(grid);
    }
}
