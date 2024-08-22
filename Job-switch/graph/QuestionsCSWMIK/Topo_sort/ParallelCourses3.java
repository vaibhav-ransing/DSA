package QuestionsCSWMIK.Topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class ParallelCourses3 {

    class Solution {
        public int minimumTime(int n, int[][] relations, int[] time) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            int[] indegree = new int[n + 1];
            for (int[] edge : relations) {
                graph.get(edge[0]).add(edge[1]);
                indegree[edge[1]]++;
            }

            int[] dp = new int[n + 1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    dp[i] = time[i - 1];
                }
            }

            while (queue.size() > 0) {
                int src = queue.remove();

                for (int nbr : graph.get(src)) {
                    indegree[nbr]--;
                    // max distance to reach nbr from src
                    // in src also max dist will be stored.
                    // so we fill dp with max-time to reach particular node
                    dp[nbr] = Math.max(dp[nbr], dp[src] + time[nbr - 1]); // Maximize the time
                    if (indegree[nbr] == 0) {
                        queue.add(nbr);
                    }
                }
            }

            return Arrays.stream(dp).max().orElse(0);
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];

        for (int[] edge : relations) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[] dp = new int[n + 1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(new int[] { i, time[i - 1] });
                dp[i] = time[i - 1];
            }
        }

        while (queue.size() > 0) {
            int[] peek = queue.remove();
            int src = peek[0];
            int totalTime = peek[1];
            dp[src] = Math.max(dp[src], totalTime);

            for (int nbr : graph.get(src)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(new int[] { nbr, dp[src] + time[nbr - 1] });
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().orElse(0);
    }
}
