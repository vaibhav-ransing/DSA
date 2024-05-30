package TopologicalSort;

import java.util.*;
import java.util.stream.IntStream;

public class KahansAlgo {

    public int[] findOrder(int n, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] in_degree = new int[n];

        // increase the indegree if node
        for (int i = 0; i < graph.size(); i++) {
            for (int u : graph.get(i)) {
                in_degree[u]++;
            }
        }
        // Push indegrees with 0 in queue
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0)
                queue.add(i);
        }

        int idx = 0;
        int ans[] = new int[n];

        while (queue.size() > 0) {
            int src = queue.remove();

            ans[idx++] = src;
            in_degree[src]--;

            for (int nbr : graph.get(src)) {
                in_degree[nbr]--;
                if (in_degree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] != -1)
                return new int[0];
        }
        return ans;
    }

}
