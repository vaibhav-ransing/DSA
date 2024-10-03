package ZRandom;

import java.util.*;

public class MinCostDisconnectLeaf {

    int minCostToDisconnectLeafNodes() {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        return dfs(6, graph, new HashSet<>());
    }

    int dfs(int src, HashMap<Integer, List<int[]>> graph, HashSet<Integer> vis) {
        if (vis.contains(src))
            return Integer.MAX_VALUE;

        vis.add(src);

        int ans = Integer.MAX_VALUE;

        for (int[] nbr_cost : graph.get(src)) {
            int currCost = nbr_cost[1];
            int rec = dfs(nbr_cost[0], graph, vis);
            ans = Math.min(ans, Math.min(currCost, rec));
        }
        return ans;
    }

}
