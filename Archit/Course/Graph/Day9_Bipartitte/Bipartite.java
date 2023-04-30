package Course.Graph.Day9;

import java.util.Arrays;

import Course.Graph.Graph;

public class Bipartite {

    Graph graph;
    int[] visited;

    public boolean isBipartite(int[][] graph2) {

        int n = graph2.length;
        graph = new Graph(n);
        visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            for (int tar : graph2[i]) {
                graph.adj[i].add(tar);
            }
        }
        for(int i=0; i<visited.length; i++){
            if(visited[i] == -1){
                boolean isBP = dfs(i, 0);
                if(!isBP) return false;
            }
        }
        return true;
    }

    public boolean dfs(int src, int color) {
        if (visited[src] != -1 && visited[src] == color)
            return true;
        if (visited[src] != -1 && visited[src] != color)
            return false;

        visited[src] = color;

        for (int nbr : graph.adj[src]) {
            if (visited[nbr] == -1) {
                if(! (dfs(nbr, color == 0 ? 1 : 0))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
