package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras {
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new int[] { src, 0 });

        while (pq.size() > 0) {
            int[] peek = pq.remove();
            int node = peek[0];
            int dis = peek[1];

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edgeWeight = edge.get(1);
                
                // No need to keep a visited, if the new wt is more than existing wt then it wont push to pq.
                int newWeight = edgeWeight + dis;
                if (newWeight < dist[adjNode]) {
                    dist[adjNode] = newWeight;
                    pq.add(new int[] { adjNode, dist[adjNode] });
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }
        return dist;
    }
}
