package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ChepestFlightKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] }); // wt btw them is 1
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new int[] { src, 0, 0 });

        while (pq.size() > 0) {
            int[] peek = pq.remove();
            int node = peek[0];
            int dis = peek[1];
            int currK = peek[2];
            if (currK > k)
                continue;

            for (int[] edge : graph.get(node)) {
                int adjNode = edge[0];
                int edgeWeight = edge[1];

                int newWeight = edgeWeight + dis;
                if (newWeight < dist[adjNode]) {
                    dist[adjNode] = newWeight;
                    pq.add(new int[] { adjNode, dist[adjNode], currK + 1 });
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }
        return dist[dst];
    }

}
