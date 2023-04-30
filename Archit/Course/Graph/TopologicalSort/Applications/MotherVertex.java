package Course.Graph.TopologicalSort.Applications;

import java.util.ArrayList;

public class MotherVertex {
    
    class Graph {
        int n; 
        ArrayList<Integer>[] adj;

        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
        }
    }   
    public int idx;
    // public int[] topo;
    public ArrayList<Integer> topo;
    Graph graph;
    boolean[] visited;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj) {

        graph = new Graph(V);
        for(int i=0; i<adj.size(); i++){
            for(int nbr: adj.get(i)){
                graph.addEdge(i, nbr);
            }
        }
        
        idx = V-1;
        // topo = new int[V];
        topo = new ArrayList<>(V);
        visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        visited = new boolean[V];
        // dfs(topo[0]);
        dfs(topo.get(0));

        for(boolean val: visited){
            if(val == false) return -1;
        }

        return 1;

    }

    public void dfs(int src){
        
        if(visited[src]) return;
        visited[src] = true;
        
        for(int nbr : graph.adj[src]){
            if(!visited[nbr]){
                dfs(nbr);
            }
        }
        // topo[idx--] = src;
        topo.add(0, src);
    }

}