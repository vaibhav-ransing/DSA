package TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class ShortestPathDAG {

    public int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        // for (int i = 0; i < n; i++) {
        //     if (visited[i] == false) {
                topoSort(0, graph, visited, stack);  // we want distance from 0 to all the other noedes so only get stack which are rechable from 0 
        //     }
        // }
        int distance[] = new int[n];
        // all the nodes which will be left unvisited from 0 will have max distance
        Arrays.fill(distance, Integer.MAX_VALUE); 
        distance[0] = 0;  // going to 0 from 0th node is 0

        while (stack.size() > 0) {
            int src = stack.pop();

            for (int[] nbr_wt : graph.get(src)) {
                int nbr = nbr_wt[0];
                int wt = nbr_wt[1];

                distance[nbr] = Math.min(distance[nbr], wt + distance[src]);
            }
        }
        return distance;
    }

    public void topoSort(int src, ArrayList<ArrayList<int[]>> graph, boolean[] visited, Stack<Integer> stack) {
        if (visited[src])
            return;

        visited[src] = true;
        for (int[] nbr_wt : graph.get(src)) {
            topoSort(nbr_wt[0], graph, visited, stack);
        }
        stack.push(src);
    }
}
