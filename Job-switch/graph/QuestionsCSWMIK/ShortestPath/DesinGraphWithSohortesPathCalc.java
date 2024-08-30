package QuestionsCSWMIK.ShortestPath;

import java.util.*;

public class DesinGraphWithSohortesPathCalc {

    class Graph {
        int n;
        int[][] mat;

        public Graph(int n, int[][] edges) {
            this.n = n;
            mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.MAX_VALUE / 2;
                }
            }

            for (int i = 0; i < n; i++) {
                mat[i][i] = 0;
            }
            for (int[] edge : edges) {
                mat[edge[0]][edge[1]] = edge[2];
            }

            floyedWarshall();
        }

        void floyedWarshall() {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            int u = edge[0], v = edge[1], weight = edge[2];

            // Update the edge weight if the new edge provides a shorter path
            if (mat[u][v] > weight) {
                mat[u][v] = weight;

                // Recompute all pairs shortest paths considering the new edge
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][u] + weight + mat[v][j]);
                    }
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            return mat[node1][node2] == Integer.MAX_VALUE / 2 ? -1 : mat[node1][node2];
        }
    }

    // Dij graph
    class Graph1 {
        ArrayList<ArrayList<int[]>> graph;
        int n;

        public Graph1(int n, int[][] edges) {
            this.n = n;
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
            }
        }

        public void addEdge(int[] edge) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        public int shortestPathDijk(int node1, int node2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE / 2);
            dis[node1] = 0;

            pq.add(new int[] { node1, 0 });
            while (pq.size() > 0) {

                int[] peek = pq.poll();
                int src = peek[0];
                int cost = peek[1];
                if (src == node2)
                    return cost;

                for (int[] nbr_cost : graph.get(src)) {
                    int newCost = cost + nbr_cost[1];
                    int nbr = nbr_cost[0];
                    if (newCost < dis[nbr]) {
                        dis[nbr] = newCost;
                        pq.add(new int[] { nbr, newCost });
                    }
                }
            }
            return dis[node2] == Integer.MAX_VALUE / 2 ? -1 : dis[node2];
        }
    }
}
