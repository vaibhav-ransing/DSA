package Course.Graph.TopologicalSort;

import java.util.ArrayList;

public class sort {
    
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ans;
    static boolean[] visited;
    static int index;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        ans = new int[V];
        graph = adj;
        index = V-1;
        visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i])
                DFS(i);
        }
        return ans;
    }

    static void DFS(int src){
        if(visited[src]) return;
        visited[src] = true;

        for(int nbr : graph.get(src)){
            if(visited[nbr]==false){
                DFS(nbr);
            }
        }
        ans[index--] = src;
    }
    
}
