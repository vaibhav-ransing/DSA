package AALastGo.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static int[] bellman_ford(int n, ArrayList<int[]> edges, int s) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.copyOf(dis, n);
            for (int[] edge : edges) {
                int src = edge[0];
                int dst = edge[1];
                int edgeWt = edge[2];

                if (dis[src] != Integer.MAX_VALUE && dis[src] + edgeWt < dis[dst]) {
                    temp[dst] = dis[src] + edgeWt;
                }
            }
            dis = temp;
        }
        return dis;
    }

}
