import java.util.Arrays;

public class cherryPickupGPT {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n]; // dp[i][j][k] represents maximum cherries picked by two robots starting at
                                         // (i,j) and (k, i+j-k)
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        int maxCherries = Math.max(0, recursion(0, 0, 0, grid, dp));
        System.out.println("Maximum cherries picked: " + maxCherries);
        return maxCherries;
    }

    public static int recursion(int row1, int col1, int col2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int row2 = row1 + col1 - col2;
        if (row1 == n || col1 == n || col2 == n || row2 == n || grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (dp[row1][col1][col2] != Integer.MIN_VALUE) {
            return dp[row1][col1][col2];
        }
        if (row1 == n - 1 && col1 == n - 1) {
            return grid[row1][col1];
        }
        int cherries = grid[row1][col1];
        if (col1 != col2) {
            cherries += grid[row2][col2];
        }
        int maxCherries = Math.max(
                Math.max(recursion(row1 + 1, col1, col2, grid, dp),
                        recursion(row1, col1 + 1, col2, grid, dp)),
                Math.max(recursion(row1 + 1, col1, col2 + 1, grid, dp),
                        recursion(row1, col1 + 1, col2 + 1, grid, dp)));
        if (maxCherries != Integer.MIN_VALUE) {
            dp[row1][col1][col2] = cherries + maxCherries;
        }
        return dp[row1][col1][col2];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {-1, 1, 1, 1, -1},
            {0, 1, 1, 1, 0},
            {1, 0, -1, 0, 0}
        };
        
        int result = cherryPickup(matrix);
        
        // Displaying the matrix after picking cherries
        System.out.println("Matrix after picking cherries:");
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
