package ShortestPathQuestion;

import java.util.*;

public class SP_in_weightedUndirectedGraph {

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        n = n + 1;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) { // u, v, wt
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new int[] { v, wt });
            graph.get(v).add(new int[] { u, wt });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // src, wt
        pq.add(new int[] { 1, 0 });

        int dist[] = new int[n];
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;

        while (pq.size() > 0) {
            int[] peek = pq.remove();
            int src = peek[0];
            int wt = peek[1];

            for (int[] adj : graph.get(src)) {
                int nbr = adj[0];
                int newWt = wt + adj[1];
                if (dist[nbr] == Integer.MAX_VALUE ||  newWt < dist[nbr]) {
                    dist[nbr] = newWt;
                    pq.add(new int[] { nbr, newWt });
                    parent[nbr] = src;
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(dist));
        
        // Store the final path in the ‘path’ array.
        List<Integer> path = new ArrayList<>();

        // If distance to a node could not be found, return an array containing -1.
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = n;
        // o(N)
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);

        // Since the path stored is in a reverse order, we reverse the array
        // to get the final answer and then return the array.
        Collections.reverse(path);
        return path;
    }
}
