import java.util.ArrayList;


public class CityWithMinRechableCities {

    ArrayList<ArrayList<int[]>> graph;
    boolean[] visited;

    public void buildGraph(int n, int[][] edges) {

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) { // from, to, wt
            graph.get(e[0]).add(new int[] { e[1], e[2] });
            graph.get(e[1]).add(new int[] { e[0], e[2] });
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        buildGraph(n, edges);
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            int tc = dfs(i, distanceThreshold);
            System.out.println(i + " " + tc);
            if (tc <= min) {
                ans = i;
                min = tc;
            }
        }
        return ans;
    }

    public int dfs(int src, int dis) {
        if (dis < 0 || visited[src])
            return 0;
        visited[src] = true;
        int count = 1;
        for (int[] nbr_wt : graph.get(src)) {
            count += dfs(nbr_wt[0], dis - nbr_wt[1]);
        }
        return count;
    }
}