package AALastGo.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FloyedWarshal {

    public void solution(ArrayList<ArrayList<int[]>> graph) {
        int n = graph.size();
        int dp[][] = new int[n][n];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
      
        for (int i = 0; i < n; i++) {
            for (int[] edge : graph.get(i)) {
                int src = edge[0];
                int dst = edge[1];
                int wt = edge[2];
                dp[src][dst] = wt; 
            }
            dp[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

    }
}
