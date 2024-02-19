package First10;

public class GoleMine2PathWithMaxGold {

    public int getMaximumGold(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] || grid[i][j] != 0) {
                    ans = Math.max(ans, helper(grid, i, j, visited, 0));
                }
            }
        }
        return ans;
    }

    public int helper(int[][] grid, int i, int j, boolean[][] visited, int count) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int maxCount = 0;
        visited[i][j] = true;
        for (int[] d : dir) {
            int ii = i + d[0];
            int jj = j + d[1];
            maxCount = Math.max(maxCount, helper(grid, ii, jj, visited, count));
        }
        visited[i][j] = false;

        return maxCount + grid[i][j];
    }

    // [[0,6,0],
    // [5,8,7],
    // [0,9,0]]

    public static void main(String[] args) {

    }
}
