package QuestionsCSWMIK.DFS;

import java.util.*;

public class ReorderRoutestsToLeadToZero {

    public int minReorder(int n, int[][] connections) {
        boolean[] pointinToZero = new boolean[n];
        pointinToZero[0] = true;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]); // u -> v
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!pointinToZero[i]) {
                count += dfs(i, graph, pointinToZero);
            }
        }
        return count;
    }

    public int dfs(int src, List<List<Integer>> graph, boolean[] pointinToZero) {


        // if it is already poitng to any zero node src then we dont need to reverse any direction here
        for (int nbr : graph.get(src)) {
            pointinToZero[src] |= pointinToZero[nbr];
        }
        int count = pointinToZero[src] ? 0 : 1;
        for (int nbr : graph.get(src)) {
            pointinToZero[src] = true;
            count += dfs(nbr, graph, pointinToZero);
        }
        return count;
    }
}