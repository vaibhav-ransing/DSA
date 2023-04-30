package Course.Graph.Day7;

import java.util.ArrayList;

public class CycleInDirected {

    ArrayList<ArrayList<Integer>> graph;
    int[] visited;

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new int[V];
        graph = adj;

        for(int i=0; i<V; i++){
            if( dfs(i) ) return true;
        }
        return false;
    }

    public boolean dfs(int src) {
        if (visited[src] == 1)
            return true;
        if(visited[src]==2)
            return false;

        visited[src] = 1;
        
        for(int nbr : graph.get(src)){
            if(dfs(nbr)) return true;
        }

        visited[src] = 2;

        return false;
    }
}
