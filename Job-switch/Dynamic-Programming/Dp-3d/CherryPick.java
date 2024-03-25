import java.util.Arrays;

public class CherryPick {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int ans = recursion(0, 0, grid, dp, n);

        System.out.println(ans);
        for (int d[] : dp)
            System.out.println(Arrays.toString(d));
        System.out.println();
        for (int g[] : grid)
            System.out.println(Arrays.toString(g));

        return ans;
    }

    public static int recursion(int row, int col, int[][] grid, int dp[][], int n) {

        if (row == n - 1 && col == n - 1) {
            int val = grid[row][col];
            if (val == -1) {
                return Integer.MIN_VALUE;
            } else {
                grid[row][col] = 0;
                return val;
            }
        }
        if (row >= n || col >= n) {
            return Integer.MIN_VALUE;
        }
        if (row >= n || col >= n || grid[row][col] == -1) {
            return Integer.MIN_VALUE;
        }
        int down = recursion(row + 1, col, grid, dp, n);
        int right = recursion(row, col + 1, grid, dp, n);

        if (down == Integer.MIN_VALUE && right == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int temp = grid[row][col];
        grid[row][col] = 0;
        int val = temp + (down == Integer.MIN_VALUE ? 0 : down) + (right == Integer.MIN_VALUE ? 0 : right);
        return val;

    }

    public static int recursion2(int row, int col, int[][] grid, int dp[][], int n) {

        if (row >= n || col >= n || grid[row][col] == -1 || dp[row][col] != 0)
            return Integer.MIN_VALUE;

        if (row == n - 1 && col == n - 1)
            return grid[n - 1][n - 1] == -1 ? Integer.MIN_VALUE : grid[n - 1][n - 1];

        int down = recursion2(row + 1, col, grid, dp, n);
        // int down = Integer.MIN_VALUE;
        int right = recursion2(row, col + 1, grid, dp, n);

        int sum = (down == Integer.MIN_VALUE ? 0 : down) +
                (right == Integer.MIN_VALUE ? 0 : right);
        // System.out.println(down +" "+right);
        int val = (down == Integer.MIN_VALUE && right == Integer.MIN_VALUE) ? Integer.MIN_VALUE : grid[row][col] + sum;

        grid[row][col] = val;
        return dp[row][col] = val;
    }

    public static void main(String[] args) {
        // int[][] matrix = {
        //         { 0, 1, -1 },
        //         { 1, 0, -1 },
        //         { 1, 1, 1 }
        // };
        // int[][] matrix = {
        // { 1, 1, -1 },
        // { 1, -1, 1 },
        // { -1, 1, 1 }
        // };

        int[][] matrix = {
            {0, 1, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {-1, 1, 1, 1, -1},
            {0, 1, 1, 1, 0},
            {1, 0, -1, 0, 0}
        };


        cherryPickup(matrix);
    }
}