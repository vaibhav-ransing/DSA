public class CherryPickup3D {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][][] = new int[n][n][n][n];
        return memoization(0, 0, 0, 0, dp, grid);
    }

    public static int memoization(int r1, int c1, int r2, int c2, int[][][][] dp, int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        if (r1 >= m || c1 >= n || r2 >= m || c2 >= n || grid[r1][c1] == -1
                || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == m - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2][c2] != 0)
            return dp[r1][c1][r2][c2];

        int berries = 0;
        if (r1 == r2 && c1 == c2) {
            berries += grid[r1][c1];
        } else {
            berries += (grid[r1][c1] + grid[r2][c2]);
        }

        int f1 = memoization(r1 + 1, c1, r2 + 1, c2, dp, grid); // vv
        int f2 = memoization(r1, c1 + 1, r2, c2 + 1, dp, grid); // hh
        int f3 = memoization(r1 + 1, c1, r2, c2 + 1, dp, grid); // hv
        int f4 = memoization(r1, c1 + 1, r2 + 1, c2, dp, grid); // vh

        return dp[r1][c1][r2][c2] = (berries + Math.max(Math.max(f1, f2), Math.max(f3, f4)));
    }

    public static int spaceOptimized(int r1, int c1, int r2, int[][][] dp, int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        int c2 = r1 + c1 - r2;
        if (r1 >= m || c1 >= n || r2 >= m || c2 >= n || grid[r1][c1] == -1
                || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == m - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2] != 0)
            return dp[r1][c1][r2];

        int berries = 0;
        if (r1 == r2 && c1 == c2) {
            berries += grid[r1][c1];
        } else {
            berries += (grid[r1][c1] + grid[r2][c2]);
        }

        int f1 = spaceOptimized(r1 + 1, c1, r2 + 1, dp, grid); // vv
        int f2 = spaceOptimized(r1, c1 + 1, r2, dp, grid); // hh
        int f3 = spaceOptimized(r1 + 1, c1, r2, dp, grid); // hv
        int f4 = spaceOptimized(r1, c1 + 1, r2 + 1, dp, grid); // vh

        return dp[r1][c1][r2] = (berries + Math.max(Math.max(f1, f2), Math.max(f3, f4)));
    }

    public static void main(String[] args) {

    }
}
