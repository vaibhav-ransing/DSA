package ShortestPathQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SPInDAG_Using_Topo {

    public int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        // for(int i=0; i<n; i++){  // this was giving wrong answer
        // if(visited[i] == false){
        topoSort(0, graph, visited, stack);
        // }
        // }
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (stack.size() > 0) {
            int src = stack.pop();

            for (int[] nbr_wt : graph.get(src)) {
                int nbr = nbr_wt[0];
                int wt = nbr_wt[1];

                distance[nbr] = Math.min(distance[nbr], wt + distance[src]);
            }
        }
        for (int i = 0; i < distance.length; i++) {
            distance[i] = distance[i] == Integer.MAX_VALUE ? -1 : distance[i];
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
