package ZRandom.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class FindNumberOfCoinsToPlaceInTreeNodes {

    public long[] placedCoins(int[][] edges, int[] cost) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = cost.length;
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        ans = new long[n];
        dfs(0, -1, graph, cost);
        return ans;
    }

    long[] ans;

    PriorityQueue<Integer> dfs(int src, int par, ArrayList<ArrayList<Integer>> graph, int[] cost) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int nbr : graph.get(src)) {
            if (nbr == par)
                continue;
            PriorityQueue<Integer> nbr_pq = dfs(nbr, src, graph, cost);

            while (nbr_pq.size() > 0) {
                int val = nbr_pq.poll();
                if (pq.size() < 3) {
                    pq.add(val);
                } else {
                    if (val > pq.peek()) {
                        pq.poll();
                        pq.add(val);
                    } else {
                        break;
                    }
                }
            }
        }
        if (pq.size() == 0) {   
            ans[src] = 1;
        } else {
            long load = 1;
            while (pq.size() > 0) {
                load *= pq.poll();
            }
            ans[src] = load > 1 ? load : 0;
        }
        pq.add(cost[src]);
        return pq;
    }
}
