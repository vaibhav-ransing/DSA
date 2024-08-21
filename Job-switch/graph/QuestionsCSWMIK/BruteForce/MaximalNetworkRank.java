package QuestionsCSWMIK.BruteForce;

import java.util.ArrayList;
import java.util.HashSet;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : roads) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int c1 = graph.get(i).size();
                int c2 = graph.get(j).size();
                if (graph.get(j).contains(i))
                    c2--;
                ans = Math.max(ans, c1 + c2);
            }
        }
        return ans;
    }
}
