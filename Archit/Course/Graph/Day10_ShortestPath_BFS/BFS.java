package Course.Graph.Day10_ShortestPath_BFS;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import Course.Graph.Graph;
// https://www.codingninjas.com/codestudio/problems/shortest-path-in-an-unweighted-graph_981297?leftPanelTab=0

public class BFS {

    static class Pair {
        String path;
        int src;

        Pair(int src, String path) {
            this.path = path;
            this.src = src;
        }
    }

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int srcMain, int tgtMain) {

        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.addUndirecrted(edge[0] - 1, edge[1] - 1);
        }

        boolean[] visited = new boolean[n];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(1, "1"));
        String ans = "";
        while (queue.size() > 0) {
            Pair peek = queue.remove();
            if(peek.src == tgtMain){
                System.out.println(peek.path + peek.src);
                ans = peek.path + "," + peek.src;
                break;
            }
            if (visited[peek.src])
                continue;
            visited[peek.src] = true;

            for (int nbr : graph.adj[peek.src]) {
                if (!visited[nbr]) {
                    queue.add(new Pair(nbr, peek.path + "," + nbr));
                }
            }
        }

        String[] path = ans.split(",");

        LinkedList<Integer> list = new LinkedList<>();
        for(String val : path){
            System.out.println(val);
            // int temp = Integer.parseInt(val);
            // list.addFirst(temp);
        }

        return list;
    }
}
