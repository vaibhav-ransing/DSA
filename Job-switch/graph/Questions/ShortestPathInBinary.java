package Questions;

import java.util.ArrayDeque;

public class ShortestPathInBinary {

    int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, 1 }); // row, col, wt
        grid[0][0] = 1; // Mark the starting cell as visited

        while (queue.size() > 0) {
            int[] peek = queue.remove();
            int row = peek[0];
            int col = peek[1];
            int wt = peek[2];

            if (row == n - 1 && col == n - 1) {
                return wt;
            }
            // grid[row][col] = 1;  // this was giving tle.

            for (int[] d : dir) {
                int rr = row + d[0];
                int cc = col + d[1];

                if (rr >= 0 && cc >= 0 && rr < n && cc < n && grid[rr][cc] == 0) {
                    queue.add(new int[] { rr, cc, wt + 1 });
                    grid[rr][cc] = 1; // Mark the cell as visited
                }
            }
        }
        return -1;
    }

}
