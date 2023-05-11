package Course.Graph.Day11_ShortestPath_wrighted_Djikstras;

import java.beans.Visibility;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.Query;
public class NetworkDelayTime {
    
    class Pair implements Comparable<Pair> {
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    class Graph{
        int n;
        ArrayList<Pair>[] adj;

        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
            }
        }
        void addEdge(int src, int dest, int wt){
            adj[src].add(new Pair(dest, wt));
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        Graph graph =  new Graph(n);
        for(int[] edge : times){
            graph.adj[edge[0]-1].add(new Pair(edge[1]-1, edge[2]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(k-1, 0));
        boolean[] visited = new boolean[n];

        int ans = 0;
        while(queue.size() > 0){
            Pair peek = queue.remove();
            if(visited[peek.node]) continue;

            visited[peek.node] = true;
            ans = peek.wt;
                
            for(Pair nbr : graph.adj[peek.node] ){
                queue.add(new Pair(nbr.node, peek.wt + nbr.wt));
            }
        }
        for(boolean val : visited){
            if(!val) return -1;
        }
        return ans;
    }
}