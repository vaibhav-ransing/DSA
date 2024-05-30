import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FindEventualSafeStetes {

    static HashSet<Integer> terminals;
    static boolean[] visited;
    static boolean[] trackPath;
    static HashSet<Integer> cycleSet;

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        visited = new boolean[n];
        trackPath = new boolean[n];

        terminals = new HashSet<>();
        cycleSet = new HashSet<>();

        // Find all the ternimal nodes
        for (int i = 0; i < n; i++) {
            int[] edges = graph[i];
            if (edges.length == 0)
                terminals.add(i);
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (!cycleSet.contains(i))
                ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }

    public static boolean dfs(int src, int[][] graph) {

        if (trackPath[src])
            return false;
        if (visited[src])
            return true;

        if (terminals.contains(src))
            return true;

        visited[src] = true;
        trackPath[src] = true;
        boolean ans = true;

        for (int nbr : graph[src]) {
            ans = ans && dfs(nbr, graph);
        }
        trackPath[src] = false;
        if (ans == false)
            cycleSet.add(src);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        eventualSafeNodes(graph);
    }

}
