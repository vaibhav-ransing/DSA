package QuestionsCSWMIK.DFS;

import java.util.ArrayList;
import java.util.List;

public class UnrechablePariNodes {

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        // ArrayList<Integer> list = new ArrayList<>();
        long count = 0;
        int nodeFound = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, vis, graph);
                count += size * (long) (n - size - nodeFound);
                nodeFound += size;
            }
        }
        return count;
        // int count = 0;
        // for (int i = 0; i < list.size(); i++) {
        //     for (int j = i + 1; j < list.size(); j++) {
        //         count += list.get(i) * list.get(j);
        //     }
        // }
        // return count;
    }

    public int dfs(int src, boolean[] vis, List<List<Integer>> graph) {
        if (vis[src])
            return 0;
        vis[src] = true;
        int count = 0;
        for (int nbr : graph.get(src)) {
            count += dfs(nbr, vis, graph);
        }
        return count + 1;
    }
}
