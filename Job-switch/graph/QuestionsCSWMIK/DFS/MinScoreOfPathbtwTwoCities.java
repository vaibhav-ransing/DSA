package QuestionsCSWMIK.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinScoreOfPathbtwTwoCities {

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> gr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<int[]>());
        }

        for (int[] edge : roads) {
            gr.get(edge[0]).add(new int[] { edge[1], edge[2] }); // u -> {v, dis}
            gr.get(edge[1]).add(new int[] { edge[0], edge[2] }); // v -> {u, dis}
        }
        boolean[] vis = new boolean[n + 1];
        return dfs(1, vis, gr, Integer.MAX_VALUE);
    }

    public int dfs(int src, boolean[] vis, List<List<int[]>> gr, int currentMin) {
        vis[src] = true;

        for (int[] nbr : gr.get(src)) {
            int nextNode = nbr[0];
            int dist = nbr[1];

            currentMin = Math.min(currentMin, dist);

            if (!vis[nextNode]) {
                currentMin = dfs(nextNode, vis, gr, currentMin);
            }
        }

        return currentMin;
    }


    public int minScoreDSU(int n, int[][] roads) {
        DSU ds = new DSU(n+1);
        for(int[] edge: roads){
            ds.union(edge[0], edge[1], edge[2]);
        }
        int v = ds.min[ds.find(n)];
        return v;
    }
    class DSU {
        int[] min;
        int[] parent;
        int n;

        DSU(int n) {
            this.min = new int[n];
            Arrays.fill(min, Integer.MAX_VALUE);
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y, int dis) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy) {
                min[xx] = Math.min(min[xx], dis);
            }
            int newMin = Math.min(min[xx], Math.min(min[yy], dis));
            parent[xx] = yy;
            min[yy] = newMin;
        }
    }
}
