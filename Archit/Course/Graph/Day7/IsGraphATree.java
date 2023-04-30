package Course.Graph.Day7;

import Course.Graph.Graph;

public class IsGraphATree {

    // Start from 0 (i.e root)
    // from root there should be no cycle
    // All the nodes from root should be connected i.e not more thatn 1 component.

    public static boolean dfsCycle(int src, int par, Graph graph, boolean[] visited) {

        if (visited[src])
            return true;
        visited[src] = true;

        for (int nbr : graph.adj[src]) {
            if (nbr == par)
                continue;
            if (dfsCycle(nbr, src, graph, visited))
                return true;
        }
        return false;
    }

    public static Boolean checkGraph(int[][] edges, int n, int m) {
        // Write your code here
        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.adj[edge[0]].add(edge[1]);
            graph.adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        boolean cycle = dfsCycle(0, -1, graph, visited);
        if (cycle)
            return false;

        for (boolean edge : visited) {
            if (!edge)
                return false;
        }
        return true;
    }
}
