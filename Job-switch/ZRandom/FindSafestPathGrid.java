package ZRandom;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class FindSafestPathGrid {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        if (grid.get(0).get(0) == 1)
            return 0;

        int[][] mat = manhatDistMatrix(grid);

        int low = 1, high = m * n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (BFS(mat, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    public boolean BFS(int[][] mat, int minDist) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        if (mat[0][0] < minDist)
            return false;
        queue.add(new int[] { 0, 0 });

        while (queue.size() > 0) {
            int peek[] = queue.poll();
            int r = peek[0];
            int c = peek[1];
            vis[r][c] = true;
            if (r == mat.length - 1 && c == mat[0].length - 1)
                return true;
            for (int[] d : dir) {
                int rr = r + d[0];
                int cc = c + d[1];
                if (rr < 0 || cc < 0 || rr >= mat.length || cc >= mat[0].length)
                    continue;
                if (mat[rr][cc] >= minDist && !vis[rr][cc]) {
                    // without marking it here it gives TLE
                    vis[rr][cc] = true;
                    queue.add(new int[] { rr, cc });
                }
            }
        }
        return false;
    }

    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] manhatDistMatrix(List<List<Integer>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] mat = new int[n][m];
        Arrays.stream(mat).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[] { i, j, 0 });
                    mat[i][j] = 0;
                }
            }
        }

        while (queue.size() > 0) {
            int[] peek = queue.poll();
            int r = peek[0];
            int c = peek[1];
            int cost = peek[2];
            if (mat[r][c] < cost)
                continue;
            mat[r][c] = cost;
            for (int[] d : dir) {
                int rr = r + d[0];
                int cc = c + d[1];
                if (rr < 0 || cc < 0 || rr >= n || cc >= m)
                    continue;
                queue.add(new int[] { rr, cc, cost + 1 });
            }

        }

        return mat;
    }
}
