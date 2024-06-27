package DFS_BFS;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CycleDectectDirected {
    static boolean[] visited;
    static boolean[] trackPath;

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        n = n + 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }

        visited = new boolean[n];
        trackPath = new boolean[n];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (dfs(i, graph))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int src, ArrayList<ArrayList<Integer>> graph) {
        if (trackPath[src]) {
            return true;
        }
        if (visited[src])
            return false;

        visited[src] = true;
        trackPath[src] = true;

        boolean ans = false;

        for (int nbr : graph.get(src)) {
            ans = ans || dfs(nbr, graph);
        }
        trackPath[src] = false;
        return ans;
    }
}
