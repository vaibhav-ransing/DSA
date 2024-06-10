package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {

    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        for (int count = 1; count < n; count++) {

            int[] temp = Arrays.copyOf(dist, n);
            for (int i = 0; i < edges.size(); i++) {
                ArrayList<Integer> edge = edges.get(i);
                int src = edge.get(0);
                int dest = edge.get(1);
                int wt = edge.get(2);

                if (dist[src] != Integer.MAX_VALUE && dist[src] + wt < temp[dest]) {
                    temp[dest] = dist[src] + wt;
                }
            }
            dist = temp;
        }
        return dist;
    }
}
