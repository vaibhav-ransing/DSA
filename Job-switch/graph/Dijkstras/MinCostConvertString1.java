package Dijkstras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostConvertString1 {

    ArrayList<ArrayList<int[]>> graph;

    public void buildGraph(char[] original, char[] changed, int[] cost) {
        graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < original.length; i++) {
            int src = original[i] - 'a';
            int dst = changed[i] - 'a';
            graph.get(src).add(new int[] { dst, cost[i] });
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        buildGraph(original, changed, cost);
        int[][] dp = new int[26][26];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int src = source.charAt(i) - 'a';
                int dst = target.charAt(i) - 'a';
                if (dp[src][dst] != Integer.MAX_VALUE) {
                    ans += dp[src][dst];
                    continue;
                }
                int cc = src_dest(src, dst);
                if (cc == -1)
                    return -1;
                ans += cc;
                dp[src][dst] = cc;
            }
        }
        return ans;
    }

    public int src_dest(int src, int dest) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[26];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[] { src, 0 });
        while (pq.size() > 0) {

            int[] peek = pq.remove();
            src = peek[0];
            int cc = peek[1];
            for (int[] adj : graph.get(src)) {
                int nbr = adj[0];
                int nbrCost = adj[1];
                if (cc + nbrCost < dist[nbr]) {
                    dist[nbr] = cc + nbrCost;
                    pq.add(new int[] { nbr, cc + nbrCost });
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    // with visited
    public int minCost(int src, int dest) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { src, 0 });
        boolean[] vis = new boolean[26];
        while (pq.size() > 0) {
            int[] peek = pq.remove();
            src = peek[0];
            int cc = peek[1];
            if (src == dest)
                return cc;
            if (vis[src])
                continue;
            vis[src] = true;
            for (int[] nbr : graph.get(src)) {
                pq.add(new int[] { nbr[0], cc + nbr[1] });
            }
        }
        return -1;
    }
}
