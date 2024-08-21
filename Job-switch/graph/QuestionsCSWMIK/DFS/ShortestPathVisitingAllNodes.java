package QuestionsCSWMIK.DFS;

import java.util.*;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int bfs = bfs(i, 0, graph);
            ans = Math.min(bfs, ans);
        }
        return ans;
    }

    public int bfs(int src, int currBit, int[][] graph) {
        int n = graph.length;
        HashSet<String> set = new HashSet<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // src, bitmask, cost

        int initialMask = (1 << src);
        queue.add(new int[] { src, initialMask, 0 });
        set.add(src + " " + initialMask);

        while (queue.size() > 0) {
            int[] peek = queue.remove();
            src = peek[0];
            int bitmask = peek[1];
            int cost = peek[2];
            

            // for nodes 0,1,2 -> all visited nodes will be 111 which in integers is 7
            // ans (1 << 3) == 1000 which is 8 --> 8-1 == 7
            if (bitmask == (1 << n) - 1) {
                return cost;
            }

            for (int nbr : graph[src]) {

                int newMask = (bitmask | (1 << nbr));
                String key = nbr + "," + newMask;

                if (!set.contains(key)) {
                    queue.add(new int[] { nbr, newMask, cost + 1 });
                    set.add(key);
                }
                // queue.add(new int[] { nbr, (bitmask | (1 << nbr)), cost + 1 });
            }
        }
        return -1;
    }

    // ------------------------- DFS SOLUTION -------------------------

    public int shortestPathLengthDFS(int[][] graph) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int dfs = dfs(i, 0, graph, new HashSet<>());
            ans = Math.min(dfs, ans);
        }
        return ans;
    }

    int nc = 0;

    public int dfs(int src, int currBit, int[][] graph, HashSet<Integer> set) {
        int newBit = (currBit | (1 << src));
        if (set.contains(newBit)) {
            return 0;
        }

        set.add(newBit);
        int count = 0;
        for (int nbr : graph[src]) {
            count += dfs(nbr, newBit, graph, set);
        }
        return 1 + count;
    }

    public static void main(String[] args) {

    }
}
