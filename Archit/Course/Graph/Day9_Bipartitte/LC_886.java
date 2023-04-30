package Course.Graph.Day9_Bipartitte;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;


public class LC_886 {

    Graph graph;
    int[] visited;

    class Pair {
        int color;
        int src;

        Pair(int src, int color) {
            this.color = color;
            this.src = src;
        }
    }

    class Graph {
    
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

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // n = n+1;
        graph = new Graph(n);
        visited = new int[n];
        Arrays.fill(visited, -1);

        for(int[] edge: dislikes){
            graph.adj[edge[0]-1].add(edge[1]-1);
            graph.adj[edge[1]-1].add(edge[0]-1);
        }
        for(int i=0; i<n; i++){
            if(visited[i] == -1){
                if(bfs(i) == false) return false;
            }
        }
        return true;
    }

    public boolean bfs(int s){
        Pair p = new Pair(s, 0);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(p);

        while(queue.size() > 0){
            Pair peek = queue.remove();
            if(visited[peek.src] == peek.color) continue;

            if(visited[peek.src] != -1) return false;

            visited[peek.src] = peek.color;

            for(int nbr : graph.adj[peek.src]){
                // if(visited[nbr] == -1){
                queue.add(new Pair(nbr, peek.color == 0? 1:0));
                // }
            }
            
        }
        return true;
    }

}
