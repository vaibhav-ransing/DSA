package Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathMinEfforts {

    int[][] dir = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // row, col, effort
        pq.add(new int[] { 0, 0, 0 });

        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] effort = new int[n][m];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        while (pq.size() > 0) {
            int[] peek = pq.remove(); // row, col, effort
            int row = peek[0];
            int col = peek[1];
            int currEffort = peek[2];

            if (row == n - 1 && col == m - 1) {
                return currEffort;
            }
            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] d : dir) {
                int rr = row + d[0];
                int cc = col + d[1];

                if (rr >= 0 && cc >= 0 && rr < n && cc < m && !visited[rr][cc]) {
                    int newEffort = Math.max(currEffort, Math.abs(heights[rr][cc] - heights[row][col]));
                    if (newEffort < effort[rr][cc]) {
                        effort[rr][cc] = newEffort;
                        pq.add(new int[] { rr, cc, newEffort });
                    }
                }
            }
        }
        return -1;
    }
}
