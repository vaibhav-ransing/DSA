package Course.Graph.Day11_ShortestPath_wrighted;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.codingninjas.com/codestudio/problems/reverse-edges_1200162?leftPanelTab=0

public class MERTRD {
    
    public static class Pair implements Comparable<Pair> {
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
    static class Graph {
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
    public static int reverseEdges(int n, int start, int end, ArrayList<ArrayList<Integer>> edgeList) {

        Graph graph = new Graph(n);
        // for(int src=0; src<edgeList.size(); src++){
        //     for(int nbr : edgeList.get(src)){
        //         graph.adj[src].add(new Pair(nbr, 0));
        //         graph.adj[nbr].add(new Pair(src, 1));
        //     }
        // }
        for(ArrayList<Integer> edge : edgeList){
            graph.adj[edge.get(0)].add(new Pair(edge.get(1), 0));
            graph.adj[edge.get(1)].add(new Pair(edge.get(0), 1));
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start, 0));

        while(queue.size() > 0){
            Pair peek = queue.remove();
            visited[peek.node] = true;
            if(peek.node == end){
                 return peek.wt;
            }
            for(Pair nbr : graph.adj[peek.node]){
                if(!visited[nbr.node]){
                    queue.add(new Pair(nbr.node, peek.wt + nbr.wt));
                }
            }
        }
        return -1;
    }





}
