import java.util.Arrays;

public class CHerryPickUp2 {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][][] = new int[m][n][m][n];
        // return memoization(0, 0, 0, n - 1, dp, grid);

        int dpLowSpace[][][] = new int[m][n][n];
        return spaceOptimized(0, 0, n-1, dpLowSpace, grid);
    }

    // Time complexity recursion 3^n * 3^n 
    // DP soln TC: O(M*N*N)*9 , SC: O(M*N*N)
    public static int spaceOptimizedMinimizedCode(int r1, int c1, int c2, int[][][] dp, int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        if (r1 >= m || c1 < 0 || c2 < 0 || c1 >= n || c2 >= n)
            return Integer.MIN_VALUE;

        if (r1 == m - 1 ){ //&& c1 == n - 1
            return c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];
        }
        

        if (dp[r1][c1][c2] != 0)
            return dp[r1][c1][c2];

        int berries = 0;
        if (c1 == c2) {
            berries += grid[r1][c1];
        } else {
            berries += (grid[r1][c1] + grid[r1][c2]);
        }
        int max = 0;
        for(int p1 = -1; p1 <2; p1++){
            for(int j=-1; j<2; j++){
                int val = spaceOptimizedMinimizedCode(r1+1, c1+p1, c2+j, dp, grid);
                max = Math.max(max, val);
            }   
        }
        return dp[r1][c1][c2] = berries + max;
    }


    public static int spaceOptimized(int r1, int c1, int c2, int[][][] dp, int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        if (r1 >= m || c1 < 0 || c2 < 0 || c1 >= n || c2 >= n)
            return Integer.MIN_VALUE;

        if (r1 == m - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][c2] != 0)
            return dp[r1][c1][c2];

        int berries = 0;
        if (c1 == c2) {
            berries += grid[r1][c1];
        } else {
            berries += (grid[r1][c1] + grid[r1][c2]);
        }
        int max = 0;
        for(int p1 = -1; p1 <2; p1++){
            for(int j=-1; j<2; j++){
                int val = spaceOptimized(r1+1, c1+p1, c2+j, dp, grid);
                max = Math.max(max, val);
            }   
        }
        return dp[r1][c1][c2] = berries + max;

        // These below steps are handled by above for loop
        // int p1l = spaceOptimized(r1 + 1, c1 - 1, c2 - 1, dp, grid);
        // int p2l = spaceOptimized(r1 + 1, c1 - 1, c2, dp, grid);
        // int p3l = spaceOptimized(r1 + 1, c1 - 1, c2 + 1, dp, grid);

        // int p1m = spaceOptimized(r1 + 1, c1, c2 - 1, dp, grid);
        // int p2m = spaceOptimized(r1 + 1, c1, c2, dp, grid);
        // int p3m = spaceOptimized(r1 + 1, c1, c2 + 1, dp, grid);

        // int p1r = spaceOptimized(r1 + 1, c1 + 1, c2 - 1, dp, grid);
        // int p2r = spaceOptimized(r1 + 1, c1 + 1, c2, dp, grid);
        // int p3r = spaceOptimized(r1 + 1, c1 + 1, c2 + 1, dp, grid);

        // int[] values = { p1l, p2l, p3l, p1m, p2m, p3m, p1r, p2r, p3r, };
        // int val = Arrays.stream(values).max().orElse(Integer.MIN_VALUE);

        // return dp[r1][c1][c2] = berries + (val == Integer.MIN_VALUE ? 0 : val);
    }

    public static int memoization(int r1, int c1, int r2, int c2, int[][][][] dp, int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;
        if (r1 >= m || c1 < 0 || c2 < 0 || c1 >= n || r2 >= m || c2 >= n)
            return Integer.MIN_VALUE;

        if (r1 == m - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][r2][c2] != 0)
            return dp[r1][c1][r2][c2];

        int berries = 0;
        if (r1 == r2 && c1 == c2) {
            berries += grid[r1][c1];
        } else {
            berries += (grid[r1][c1] + grid[r2][c2]);
        }

        int p1l = memoization(r1 + 1, c1 - 1, r2 + 1, c2 - 1, dp, grid);
        int p2l = memoization(r1 + 1, c1 - 1, r2 + 1, c2, dp, grid);
        int p3l = memoization(r1 + 1, c1 - 1, r2 + 1, c2 + 1, dp, grid);

        int p1m = memoization(r1 + 1, c1, r2 + 1, c2 - 1, dp, grid);
        int p2m = memoization(r1 + 1, c1, r2 + 1, c2, dp, grid);
        int p3m = memoization(r1 + 1, c1, r2 + 1, c2 + 1, dp, grid);

        int p1r = memoization(r1 + 1, c1 + 1, r2 + 1, c2 - 1, dp, grid);
        int p2r = memoization(r1 + 1, c1 + 1, r2 + 1, c2, dp, grid);
        int p3r = memoization(r1 + 1, c1 + 1, r2 + 1, c2 + 1, dp, grid);

        int[] values = { p1l, p2l, p3l, p1m, p2m, p3m, p1r, p2r, p3r, };
        int val = Arrays.stream(values).max().orElse(Integer.MIN_VALUE);

        return dp[r1][c1][r2][c2] = berries + (val == Integer.MIN_VALUE ? 0 : val);
    }
}