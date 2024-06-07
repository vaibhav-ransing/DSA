package Questions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxPathQualityOfGraph {

    int ans;
    int[] values;
    ArrayList<ArrayList<int[]>> graph;
    int[] visisted;

    public int maximalPathQuality(int[] vals, int[][] edges, int maxTime) {
        values = vals;
        ans = 0;
        visisted = new int[vals.length];

        graph = new ArrayList<>();
        for (int i : values) {
            graph.add(new ArrayList());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            graph.get(u).add(new int[] { v, t });
            graph.get(v).add(new int[] { u, t });
        }
        dfs(0, maxTime, 0);
        return ans;
    }

    public void dfs(int src, int maxTime, int score) {

        if (visisted[src] == 0) {
            score += values[src];
        }
        if (src == 0) {
            ans = Math.max(ans, score);
        }
        visisted[src]++;
        for (int[] nbr_time : graph.get(src)) {
            int nbr = nbr_time[0];
            int currTime = nbr_time[1];
            if (maxTime - currTime >= 0) { // this wont let infinite loop as time is reducing
                dfs(nbr, maxTime - currTime, score);
            }
        }
        visisted[src]--;
    }
}
