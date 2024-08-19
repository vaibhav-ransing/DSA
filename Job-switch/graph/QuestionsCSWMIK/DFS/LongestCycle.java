package QuestionsCSWMIK.DFS;

public class LongestCycle {

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] track = new int[n];
                ans = Math.max(ans, dfs(i, track, 1, edges, vis));
            }
        }
        return ans;
    }

    public int dfs(int src, int[] track, int count, int[] edges, boolean[] visited) {
        if (src == -1 || visited[src])
            return -1;
        if (track[src] != 0) {
            return count - track[src];
        }
        if (track[src] == -1)
            return -1;
        track[src] = count;
        int val = dfs(edges[src], track, count + 1, edges, visited);
        visited[src] = true;

        return val;
    }
}
