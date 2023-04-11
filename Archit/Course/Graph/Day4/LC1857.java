package Course.Graph.Day4;

import java.util.ArrayList;
import java.util.HashMap;

public class LC1857 {

    static class Pair {
        char color;
        int idx;

        Pair(int idx, char color) {
            this.color = color;
            this.idx = idx;
        }
    }

    static class Graph {

        int n;
        ArrayList<Integer>[] adj;

        Graph(int n) {
            this.n = n;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest) {
            adj[src].add(dest);
        }
    }

    static int maxAns = 0;
    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Graph graph = new Graph(n);
        for (int edge[] : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];
        HashMap<Character, Integer> map = new HashMap<>();
        helper(graph, 0, map, 0, visited, colors);
        System.out.println(maxAns);
        return maxAns;
    }

    public static int helper(Graph graph, int src, HashMap<Character,Integer> map, 
                        int max, boolean[] visited, String colors){

        if(visited[src]) return -1;
        visited[src] = true;
        char ch = colors.charAt(src);
        map.put(ch, map.getOrDefault(ch, 0)+1);

        max = Math.max(max, map.get(ch));
        
        System.out.println("src "+ src + " " + max);
        
        maxAns = Math.max(max, maxAns);
        
        int val = 0;
        for(int nbr : graph.adj[src]){
            if(!visited[nbr]){
                val = helper(graph, nbr, map, max, visited, colors);
            }
        }

        map.put(ch, map.get(ch) - 1);
        if(map.get(ch)==0){
            map.remove(ch);
        }
        if(val==-1){
            int remMax = map.getOrDefault(ch, 0);
            if(remMax+1 == maxAns){
                maxAns-=1;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
        largestPathValue("abaca", edges);
    }
}
