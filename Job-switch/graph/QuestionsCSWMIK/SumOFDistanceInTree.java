package QuestionsCSWMIK;

import java.util.*;

public class SumOFDistanceInTree {
    class Solution {
        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            HashSet<Integer>[] graph = new HashSet[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new HashSet<>();
            }
            for (int vert[] : edges) {
                int e1 = vert[0];
                int e2 = vert[1];
                graph[e1].add(e2);
                graph[e2].add(e1);
            }
            int[] nodes = new int[n];
            int[] res = new int[n];
            helper(graph, nodes, res, 0, -1);
            System.out.println(Arrays.toString(res));
            System.out.println(Arrays.toString(nodes));
            helper2(graph, nodes, res, 0, -1);
            return res;
        }

        static void helper(HashSet<Integer>[] graph, int[] nodes, int[] res, int src, int par) {

            for (int nbr : graph[src]) {
                if (nbr != par) {
                    helper(graph, nodes, res, nbr, src);
                    nodes[src] += nodes[nbr];
                    res[src] += res[nbr] + nodes[nbr];
                }
            }
            nodes[src]++;
        }

        static void helper2(HashSet<Integer>[] graph, int[] nodes, int[] res, int src, int par) {

            for (int nbr : graph[src]) {
                if (nbr != par) {
                    res[nbr] = res[src] + (nodes.length - nodes[nbr]) - nodes[nbr];
                    helper2(graph, nodes, res, nbr, src);
                }
            }
        }
    }

    ArrayList<ArrayList<Integer>> graph;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                curr += dfs(i, j, new boolean[n]);
            }
            ans[i] = curr;
        }
        return ans;
    }

    public int dfs(int src, int dst, boolean[] vis) {
        if (src == dst)
            return 0;
        if (vis[src])
            return 99999;
        vis[src] = true;
        int count = 99999;
        for (int nbr : graph.get(src)) {
            count = Math.min(count, 1 + dfs(nbr, dst, vis));
        }
        vis[src] = false;
        return 1 + count;
    }

    public int[] sumOfDistancesInTreeFloyed(int n, int[][] edges) {

        int[][] mat = new int[n][n];
        Arrays.stream(mat).forEach(row -> Arrays.fill(row, 99999));
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            mat[u][v] = 1;
            mat[v][u] = 1;
        }
        for (int i = 0; i < n; i++) {
            mat[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Arrays.stream(mat[i]).sum();
        }
        return ans;
    }

}
