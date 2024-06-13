import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RestoreTheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] edges) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!graph.containsKey(u))
                graph.put(u, new ArrayList<>());
            if (!graph.containsKey(v))
                graph.put(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> ans = new ArrayList<>();

        for (int src : graph.keySet()) {
            if (graph.get(src).size() == 1) {
                helper(src, graph, new HashSet<>(), ans);
                break;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void helper(int src, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, List<Integer> ans) {

        if (visited.contains(src))
            return;
        ans.add(src);
        visited.add(src);
        for (int nbr : graph.get(src)) {
            helper(nbr, graph, visited, ans);
        }
    }
}