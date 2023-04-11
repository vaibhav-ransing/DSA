package Course.Graph.Day3_disjoint;

import java.util.ArrayList;


public class Lc2316_unrechabelPair {

    class Graph {
        ArrayList<Integer>[] adj;
        int n;

        Graph(int n) {
            this.n = n;
            this.adj = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest) {
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }

    public long countPairs(int n, int[][] edges) {
        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }
        ArrayList<Long> common = new ArrayList<>(); 
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long a = helper(graph, i, visited);
                common.add(a);
            }
        }
        System.out.println(common);
        long ans = 0;
        for(int i=0; i<common.size(); i++){
            for(int j=i+1; j<common.size(); j++){
                ans += common.get(i)*common.get(j);
            }
        }
        return ans;
    }

    public int helper(Graph graph, int src, boolean[] visited){
        if(visited[src]) return 0;

        visited[src] = true;
        int size = 1;
        for(int nbr: graph.adj[src]){
            if(!visited[nbr]){
                size += helper(graph, nbr, visited);
            }
        }
        return size;
    }
}
