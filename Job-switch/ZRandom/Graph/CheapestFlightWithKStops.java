package ZRandom.Graph;

import java.util.Arrays;

public class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 3);
        dist[src] = 0;

        for (int i = 0; i < k; i++) {
            int[] copy = Arrays.copyOf(dist, n);

            for (int[] edge : flights) {
                int curr_src = edge[0];
                int curr_dst = edge[1];
                int cost = edge[2];

                // if (dist[curr_dst] > dist[curr_src] + cost) {
                //     copy[curr_dst] = dist[curr_src] + cost;
                // }
                if (copy[curr_dst] > dist[curr_src] + cost) {
                    copy[curr_dst] = dist[curr_src] + cost;
                }
            }
            dist = copy;
        }
        return dist[dst] == Integer.MAX_VALUE / 3 ? -1 : dist[dst];
    }
}
