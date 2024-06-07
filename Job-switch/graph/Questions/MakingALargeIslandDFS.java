package Questions;
public class MakingALargeIslandDFS {

    public int largestIsland(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    int count = dfs(i, j, grid, new boolean[grid.length][grid[0].length]);
                    grid[i][j] = 0;
                    ans = Math.max(ans, count);
                }
            }
        }
        if (ans == 0) {
            return dfs(0, 0, grid, new boolean[grid.length][grid[0].length]);
        }
        return ans;
    }

    public int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int dfs(int row, int col, int[][] grid, boolean[][] visisted) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visisted[row][col]
                || grid[row][col] == 0)
            return 0;

        visisted[row][col] = true;
        int count = 0;

        for (int d[] : dir) {
            int rr = d[0] + row;
            int cc = d[1] + col;

            count += dfs(rr, cc, grid, visisted);
        }
        return count + 1;
    }
}