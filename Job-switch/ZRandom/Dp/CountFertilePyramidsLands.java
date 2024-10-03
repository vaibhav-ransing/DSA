package ZRandom.Dp;

public class CountFertilePyramidsLands {
    public int countPyramids(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int prev = j == 0 ? 0 : grid[i][j - 1];
                prefix[i][j] += prev + grid[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ht = isPyramid(i, j, j, grid, prefix);
                if (ht > 1)
                    count++;
            }
        }
        return count;
    }

    public int isPyramid(int row, int left, int right, int[][] grid, int[][] prefix) {

        if (row < 0 || row >= grid.length || left < 0 || right < 0 || left >= grid[0].length || right >= grid[0].length)
            return 0;

        if (prefix[row][right] - (left == 0 ? 0 : prefix[row][left - 1]) != right - left)
            return 0;

        int goDown = isPyramid(row + 1, left - 1, right + 1, grid, prefix);
        int goUp = isPyramid(row - 1, left - 1, right + 1, grid, prefix);

        return 1 + Math.max(goDown, goUp);
    }
}
