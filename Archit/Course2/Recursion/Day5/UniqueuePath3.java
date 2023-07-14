public class UniqueuePath3 {

    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int uniquePathsIII(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        int rowStart = -1, colStart = -1;
        int rowEnd = -1, colEnd = -1;
        int freeCells = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowStart = i;
                    colStart = j;
                } else if (grid[i][j] == 2) {
                    rowEnd = i;
                    colEnd = j;
                } else if (grid[i][j] == 0){
                    freeCells++;
                }
            }
        }
        int val = bfs(grid, freeCells + 1, rowStart, colStart, rowEnd, colEnd);
        return val;
    }

    public static int bfs(int[][] grid, int freeCells, int r, int c, int fr, int fc) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == -1) {
            return 0;
        }
        if (r == fr && c == fc) {
            if (freeCells == 0) {
                return 1;
            }
            return 0;
        }

        visited[r][c] = true;

        int count = 0;
        for (int[] d : dir) {
            int rr = r + d[0];
            int cc = c + d[1];
            count += bfs(grid, freeCells - 1, rr, cc, fr, fc);
        }

        visited[r][c] = false;
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        uniquePathsIII(grid);
    }

}
