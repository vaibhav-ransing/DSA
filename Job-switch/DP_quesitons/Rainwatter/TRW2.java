package Rainwatter;

import java.util.PriorityQueue;

public class TRW2 {

    public int trapRainWater(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int dir[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        boolean visited[][] = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.add(new int[] { arr[i][j], i, j });
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        int minHt = 0;

        while (pq.size() != 0) {
            int a[] = pq.remove();
            int r = a[1];
            int c = a[2];
            minHt = Math.max(minHt, a[0]);

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) {
                    pq.add(new int[] { arr[nr][nc], nr, nc });
                    visited[nr][nc] = true;
                    if (arr[nr][nc] < minHt)
                        ans = ans + (minHt - arr[nr][nc]);
                }
            }
        }
        return ans;
    }
}
