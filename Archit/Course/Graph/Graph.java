package Course.Graph;

import java.util.ArrayList;

public class Graph {
    
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph(int n){
        this.n = n;
       adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void add(int src, int dest){
        adj[src].add(dest);
    }

    public void addUndirecrted(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
}
