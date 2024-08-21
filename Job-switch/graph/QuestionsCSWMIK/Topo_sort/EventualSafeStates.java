package QuestionsCSWMIK.Topo_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] isSafe = new boolean[n];
        Arrays.fill(isSafe, true);
        for (int[] src : graph) {
            for (int nbr : src) {
                isSafe[nbr] = false;
            }
        }
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis, isSafe)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int src, int[][] graph, boolean[] vis, boolean[] isSafe) {
        if (vis[src])
            return isSafe[src];
        vis[src] = true;
        boolean ans = true;
        for (int nbr : graph[src]) {
            ans = ans & dfs(nbr, graph, vis, isSafe);
        }
        return isSafe[src] = ans;
    }
    
}
