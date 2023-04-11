package Course.Graph.Day3_disjoint;

import java.util.ArrayList;

public class NoOfIsland {

    class Graph {
        ArrayList<Integer>[] adj;
        int n;

        Graph(int n) {
            this.n = n;
            this.adj = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest) {
            adj[src].add(dest);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        Graph graph = new Graph(isConnected.length);
        int n = isConnected.length;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
        for (ArrayList<Integer> al : graph.adj) {
            System.out.println(al);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                helper(graph, i, visited);
            }
        }

        return count;
    }

    public void helper(Graph graph, int src, boolean[] visited) {
        if (visited[src])
            return;
        visited[src] = true;
        for (int nbr : graph.adj[src]) {
            if (!visited[nbr])
                helper(graph, nbr, visited);
        }
    }
}
