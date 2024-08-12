package QuestionsCSWMIK;

import java.util.*;

public class AllPath {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        daddy = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        dfs(0, graph.length - 1, graph, new boolean[graph.length], ans);
        return daddy;
    }

    List<List<Integer>> daddy;

    public void dfs(int src, int dst, int[][] graph, boolean[] vis, List<Integer> ans) {
        if (src == dst) {
            daddy.add(new ArrayList<>(ans));
            return;
        }
        if (vis[src])
            return;
        vis[src] = true;
        for (int nbr : graph[src]) {
            ans.add(nbr);
            dfs(nbr, dst, graph, vis, ans);
            ans.remove(ans.size() - 1);
        }
        vis[src] = false;
    }
}