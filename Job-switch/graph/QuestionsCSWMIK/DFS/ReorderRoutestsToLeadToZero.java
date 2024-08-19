package QuestionsCSWMIK.DFS;

import java.util.*;

public class ReorderRoutestsToLeadToZero {

    public int minReorder(int n, int[][] connections) {
        boolean[] pointinToZero = new boolean[n];
        pointinToZero[0] = true;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            graph.get(edge[0]).add(new int[] { edge[1], 1 }); // u -> v 1 (asli edge)
            graph.get(edge[1]).add(new int[] { edge[0], 0 }); // u -> v 0 (fake edge)
        }
        return dfs(0, -1, graph);
    }

    public int dfs(int src, int par, List<List<int[]>> graph) {
        int count = 0;
        for (int nbr_rf[] : graph.get(src)) {
            int nbr = nbr_rf[0]; 

            // if we are going away from 0 then it is real edge and going away has to be reversed
            // if it is real then cost = 1 so automatically 1 will be added to ans.
            int cost = nbr_rf[1]; 
            if (nbr != par) {
                count += cost + dfs(nbr, src, graph);
            }
        }
        return count;
    }

}