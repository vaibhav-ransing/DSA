import java.util.*;

public class KosarajuStrongConnectedComp {

    static Stack<Integer> stack;
    static boolean[] visited;

    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();

        // step 1
        stack = new Stack<>();
        visited = new boolean[n];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                topologicalDFS(i, edges);
        }
        
        // step 2
        ArrayList<ArrayList<Integer>> reversedGraph = reverseArrayGraph(edges);
        
        // step 3
        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, reversedGraph);
            }
        }
        return count;
    }

    // step 1 fill the stack and get topological sort
    public static void topologicalDFS(int idx, ArrayList<ArrayList<Integer>> edges) {
        if (visited[idx])
            return;
        visited[idx] = true;

        for (int nbr : edges.get(idx)) {
            topologicalDFS(nbr, edges);
        }
        stack.add(idx);
    }

    // step 2 reverse the graph
    public static ArrayList<ArrayList<Integer>> reverseArrayGraph(ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();
        ArrayList<ArrayList<Integer>> reversedEdges = new ArrayList<>(n);

        // Initialize the reversed adjacency list
        for (int i = 0; i < n; i++) {
            reversedEdges.add(new ArrayList<>());
        }

        // Iterate over each vertex and its adjacency list
        for (int u = 0; u < n; u++) {
            for (int v : edges.get(u)) {
                // Add an edge from v to u in the reversed graph
                reversedEdges.get(v).add(u);
            }
        }

        return reversedEdges;
    }

    // step 3
    public static void dfs(int idx, ArrayList<ArrayList<Integer>> edges) {
        if (visited[idx])
            return;
        visited[idx] = true;

        for (int nbr : edges.get(idx)) {
            dfs(nbr, edges);
        }
    }

    public static void main(String[] args) {
        System.out.println("HELIO");
    }
}
