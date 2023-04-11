package Course.Graph.Day2;

import Course.Graph.Graph;

public class FindPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Graph graph = new Graph(n);

        for(int[] edge: edges){
            graph.addUndirecrted(edge[0], edge[1]);
        }
        boolean[] visited = new boolean[n];
        
        return helper(graph, source, destination, visited);
    }   
    
    public boolean helper(Graph graph, int src, int destination, boolean[] visited){

        if(src==destination) return true;

        if(visited[src]) return false;

        for(int nbr: graph.adj[src]){
            if(!visited[nbr]){
                visited[nbr] = true;
                boolean ans =  helper(graph, nbr, destination, visited);
                if(ans) return true;
            }
        }
        return false;
    }
}
