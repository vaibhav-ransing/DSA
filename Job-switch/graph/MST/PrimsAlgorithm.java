package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PrimsAlgorithm {

    static class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static int getMinimumCost(int n, int m, int[][] connections) {
        n = n + 1;

        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));

        for (int[] edge : connections) {
            int x = edge[0];
            int y = edge[1];
            int wt = edge[2];
            graph.get(x).add(new Pair(y, wt));
            graph.get(y).add(new Pair(x, wt));
        }

        PriorityQueue<IterPair> pq = new PriorityQueue<>();
        pq.add(new IterPair(0, 1, -1));

        int ans = 0;
        while (pq.size() > 0) {
            IterPair peek = pq.remove();

            if (visited[peek.node])
                continue;
            visited[peek.node] = true;
            ans += peek.wt;

            for (Pair nbrs : graph.get(peek.node)) {
                if (!visited[nbrs.node])
                    pq.add(new IterPair(nbrs.wt, nbrs.node, peek.node));
            }
        }
        for (int i = 1; i < n; i++) {
            if (!visited[i])
                return -1;
        }
        return ans;
    }

    static class IterPair implements Comparable<IterPair> {
        int wt;
        int node;
        int parent;

        IterPair(int wt, int node, int parent) {
            this.wt = wt;
            this.node = node;
            this.parent = parent;
        }

        public int compareTo(IterPair o) {
            return this.wt - o.wt; // smaller wt should be on top
        }
    }

    public static void main(String[] args) {
        int[][] array = {
                { 1, 2, 6 },
                { 2, 3, 5 },
                { 3, 4, 4 },
                { 1, 4, 1 },
                { 1, 3, 2 },
                { 3, 5, 3 }
        };
        int n = 5;
        int m = 6;
        getMinimumCost(n, m, array);
    }

    // 5 6

    // 1 2 6
    // 2 3 5
    // 3 4 4
    // 1 4 1
    // 1 3 2
    // 3 5 3

}