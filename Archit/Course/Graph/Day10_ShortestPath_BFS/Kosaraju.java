package Course.Graph.Day10_ShortestPath_BFS;

import java.util.ArrayList;

public class Kosaraju {
    
    public int[] topo;
    public int idx;
    boolean[] visited;
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj) {
        topo = new int[n];
        idx = n-1;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, adj);
            }
        }
        ArrayList<Integer>[] reverse = new ArrayList[n];
        for(int i=0; i<n; i++){
           reverse[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int nbr : adj.get(i)){
                reverse[nbr].add(i);
            }
        }
        int count = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[topo[i]]){
                count++;
                dfs2(topo[i], reverse);
            }
        }
        return count;

    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj){
        if(visited[src]) return;
        visited[src] = true;

        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfs(nbr, adj);
            }
        }
        topo[idx--] = src;
    }

    public void dfs2(int src, ArrayList<Integer>[] reverse){
        if(visited[src]) return;
        visited[src] = true;

        for(int nbr : reverse[src]){
            if(!visited[nbr]){
                dfs2(nbr, reverse);
            }
        }
    }
    

}
