package QuestionsCSWMIK.Tree;

import java.util.ArrayList;
import java.util.List;

public class MinTimeCollectApplesTree {

    ArrayList<ArrayList<Integer>> graph;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int ans = dfs(0, -1, hasApple);
        return ans;
    }

    public int dfs(int src, int par, List<Boolean> hasApple) {
        int tc = 0;

        for (int nbr : graph.get(src)) {
            if (nbr == par)
                continue;
            int timeSubtree = dfs(nbr, src, hasApple);
            if (hasApple.get(nbr) || timeSubtree > 0) {
                tc += timeSubtree + 2;
            }
        }
        return tc;
    }
}
