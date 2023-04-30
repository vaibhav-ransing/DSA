import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Arc {

    static class Pair {
        int par;
        int src;

        Pair(int src, int par) {
            this.par = par;
            this.src = src;
        }
    }

    static class Graph {

        public int n;
        public ArrayList<Integer>[] adj;

        public Graph(int n) {
            this.n = n;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void add(int src, int dest) {
            adj[src].add(dest);
        }

        public void addUndirecrted(int src, int dest) {
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int src, int tgt) {
        n = n + 1;
        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.addUndirecrted(edge[0], edge[1]);
        }

        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(parent, -1);

        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src, -1));

        while (queue.size() > 0) {
            Pair peek = queue.remove();
            // System.out.println("peek.src "+ peek.src);
            if (peek.src == tgt) {
                parent[peek.src] = peek.par;
                break;
            }

            if (visited[peek.src])
                continue;

            visited[peek.src] = true;
            parent[peek.src] = peek.par;
            for (int nbr : graph.adj[peek.src]) {
                if (visited[nbr] == false) {
                    parent[peek.src] = peek.par;
                    queue.add(new Pair(nbr, peek.src));

                }
            }
        }
        // for (int val : parent) {
        //     System.out.print(val + " ");
        // }
        int curr = tgt;
        LinkedList<Integer> list = new LinkedList<>();
        while (curr != -1) {
            // System.out.println("curr "+ curr);
            list.addFirst(curr);
            curr = parent[curr];
        }
        // System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 8 }, { 4, 6 }, { 5, 8 }, { 6, 7 }, { 7, 8 } };
        shortestPath(edges, 8, 0, 1, 8);
    }
}
