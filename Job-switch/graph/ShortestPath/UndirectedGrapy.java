package ShortestPath;

import java.util.*;

public class UndirectedGrapy {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], 1 }); // wt btw them is 1
            graph.get(edge[1]).add(new int[] { edge[0], 1 });
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        boolean[] visisted = new boolean[n];
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // `src` and `wt till now from src`
        ArrayDeque<int[]> pq = new ArrayDeque<>(); // `src` and `wt till now from src`
        pq.add(new int[] { src, 0 });

        while (pq.size() > 0) {

            int[] src_wt = pq.remove(); // 0 , 0
            int src_curr = src_wt[0];
            int wt_till_now = src_wt[1];
            if (visisted[src_curr])
                continue;
            distance[src_curr] = wt_till_now;
            visisted[src_curr] = true;

            for (int nbr_wt[] : graph.get(src_curr)) {
                if (!visisted[nbr_wt[0]]) {
                    int nbr = nbr_wt[0];
                    int wt = nbr_wt[1];
                    pq.add(new int[] { nbr, wt + wt_till_now });
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            distance[i] = distance[i] == Integer.MAX_VALUE ? -1 : distance[i];
        }
        return distance;
    }
}