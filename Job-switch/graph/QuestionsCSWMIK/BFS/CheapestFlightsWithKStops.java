package QuestionsCSWMIK.BFS;

import java.util.*;

public class CheapestFlightsWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] }); // nbr, cost
        }
        int dis[] = new int[n];
        Arrays.fill(dis, 99999);
        dis[src] = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // src, cost
        queue.add(new int[] { src, 0 });

        while (k >= 0 && queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] peek = queue.remove();
                src = peek[0];
                int currCost = peek[1];
                for (int[] nbr_cst : graph.get(src)) {
                    int nbr = nbr_cst[0];
                    int newCost = currCost + nbr_cst[1];
                    if (newCost < dis[nbr]) {
                        dis[nbr] = newCost;
                        queue.add(new int[] { nbr, newCost });
                    }
                }
            }
            k--;
        }
        return dis[dst] == 99999 ? -1 : dis[dst];
    }

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            while (k-- >= 0) {
                int[] temp = Arrays.copyOf(dist, n);
                for (int[] edge : flights) {
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < temp[v]) {
                        temp[v] = dist[u] + wt;
                    }
                }
                dist = temp;
            }
            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }
    }

    public int findCheapestPriceMyCode(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] }); // wt btw them is 1
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // src, cost, k
        queue.add(new int[] { src, 0, k + 1 });
        int min = Integer.MAX_VALUE;
        while (queue.size() > 0) {
            int[] peek = queue.poll();
            src = peek[0];
            k = peek[2];
            if (src == dst) {
                min = Math.min(min, peek[1]);
                continue;
            }
            for (int nbr[] : graph.get(src)) {
                if (k > 0 && (peek[1] + nbr[1] < min)) {
                    int newCost = peek[1] + nbr[1];
                    queue.add(new int[] { nbr[0], newCost, k - 1 });
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}