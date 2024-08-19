package QuestionsCSWMIK.DSU;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DetonateMaxBoms {

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            int c = dfs(i, new boolean[bombs.length], bombs);
            max = Math.max(max, c);
        }
        return max;
    }

    public int dfs(int src, boolean[] vis, int[][] bombs) {
        if (vis[src])
            return 0;
        vis[src] = true;
        int count = 1;
        for (int i = 0; i < bombs.length; i++) {
            if (!vis[i]) {
                int[] p1 = bombs[i];
                int[] p2 = bombs[src];

                int x1 = p1[0];
                int y1 = p1[1];

                int x2 = p2[0];
                int y2 = p2[1];
                int r2 = p2[2];

                double disBtwCircles = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                if (disBtwCircles <= r2) {
                    count += dfs(i, vis, bombs);
                }
            }
        }
        return count;
    }

    class soln {
        public static int maximumDetonation(int[][] bombs) {
            int n = bombs.length;
            DSU ds = new DSU(n);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int p1[] = bombs[i];
                    int p2[] = bombs[j];

                    int x1 = p1[0];
                    int y1 = p1[1];
                    int dis1 = p1[2];

                    int x2 = p2[0];
                    int y2 = p2[1];
                    int dis2 = p2[2];

                    long dis = (long) Math.sqrt(Math.pow((x1 - x2), 2) + (long) Math.pow((y1 - y2), 2));
                    long maxRange = (long) Math.max(dis1, dis2);

                    if (maxRange >= dis) {
                        ds.union(i, j);
                    }
                }
            }
            return Arrays.stream(ds.size).max().orElse(-1);
        }

        static class DSU {
            int parent[];
            int size[];

            DSU(int n) {
                this.parent = new int[n];
                this.size = new int[n];
                IntStream.range(0, n).forEach(i -> parent[i] = i);
                Arrays.fill(size, 1);
            }

            int find(int u) {
                if (parent[u] == u)
                    return u;
                return parent[u] = find(parent[u]);
            }

            void union(int u, int v) {
                int pu = find(u);
                int pv = find(v);

                if (pv == pu)
                    return;

                parent[pv] = pu;
                size[pu] += size[pv];
                size[pv] = 0;

            }
        }
    }
}