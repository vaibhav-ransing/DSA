package Dijkstras;

import java.util.*;

public class SecondMinReachDest {

    ArrayList<ArrayList<Integer>> graph;

    public void buildGraph(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edg : edges) {
            int v1 = edg[0] - 1;
            int v2 = edg[1] - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    // time = 3
    // change = 5
    // 0 1 2 3 4 5 | 6 7 8 9 10 |
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        buildGraph(n, edges); // 0 -> n-1 graph
        int count = 0;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // src,
        // totalTimeElapsed
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[] { 0, 0 });
        while (pq.size() > 0) {
            int[] peek = pq.remove();
            int src = peek[0];
            int currTime = peek[1];

            if (src == n - 1)
                count++;
            if (count == 2 && src == n - 1)
                return currTime;

            for (int nbr : graph.get(src)) {
                int nextTime = currTime;
                int stopSlot = nextTime / change;
                if (stopSlot % 2 == 1) {
                    int waitingTime = (stopSlot + 1) * change - nextTime;
                    nextTime += waitingTime;
                }
                nextTime += time;
                pq.add(new int[] { nbr, nextTime });
            }

            // my code
            for (int nbr : graph.get(src)) {
                int nextTime = currTime;
                int stopSlot = currTime / change;
                if (stopSlot % 2 == 1) {
                    int waitingTime = (stopSlot + 1) * change - currTime;
                    nextTime += waitingTime;
                }
                nextTime += time;
                pq.add(new int[] { nbr, nextTime });
            }
        }
        return -1;
    }

    class Solution {

        ArrayList<ArrayList<Integer>> graph;

        public void buildGraph(int n, int[][] edges) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int v1 = edge[0] - 1;
                int v2 = edge[1] - 1;
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
        }

        public int secondMinimum(int n, int[][] edges, int time, int change) {
            buildGraph(n, edges);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[] { 0, 0 });
            int[][] dist = new int[n][2]; // Store shortest and second shortest distances
            for (int i = 0; i < n; i++) {
                dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
            }
            dist[0][0] = 0;

            while (!pq.isEmpty()) {
                int[] peek = pq.poll();
                int src = peek[0];
                int currTime = peek[1];

                for (int nbr : graph.get(src)) {
                    int nextTime = currTime;
                    int stopSlot = nextTime / change;
                    if (stopSlot % 2 == 1) {
                        nextTime += (stopSlot + 1) * change - nextTime;
                    }
                    nextTime += time;

                    if (nextTime < dist[nbr][0]) {
                        dist[nbr][1] = dist[nbr][0];
                        dist[nbr][0] = nextTime;
                        pq.add(new int[] { nbr, nextTime });
                    } else if (nextTime > dist[nbr][0] && nextTime < dist[nbr][1]) {
                        dist[nbr][1] = nextTime;
                        pq.add(new int[] { nbr, nextTime });
                    }
                }
            }
            return dist[n - 1][1];
        }
    }

}