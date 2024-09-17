
public class CherryPickup2 {

    // rec: O(9^m)*n^2
    // tabulation: O(m * n^2)
    public int cherryPickup(int[][] grid) {
        int ans = rec(0, 0, grid[0].length - 1, grid);
        return ans;
    }

    public int rec(int r1, int c1, int c2, int[][] grid) {
        if (c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length)
            return Integer.MIN_VALUE / 4;

        if (r1 == grid.length) {
            return 0;
        }

        int ans = 0;
        if (c1 == c2) {
            ans = grid[r1][c1];
        } else {
            ans = grid[r1][c1] + grid[r1][c2];
        }
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                max = Math.max(max, rec(r1 + 1, c1 + i, c2 + j, grid));
            }
        }
        return max + ans;
    }
}
