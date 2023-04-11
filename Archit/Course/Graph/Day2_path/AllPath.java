package Course.Graph.Day2;

import java.util.ArrayList;
import java.util.List;

import Course.Graph.Graph;

public class AllPath {
    


    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        
        int n = edges.length;
        Graph graph = new Graph(n);

        for(int[] edge: edges){
            graph.addUndirecrted(edge[0], edge[1]);
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for(ArrayList<Integer> t: graph.adj){
            System.out.println(t);
        }

        helper(graph, 0, n-1, visited, list, temp);

        return list;
    }

    public void helper(Graph graph, int src, int destination, 
                        boolean[] visited, List<List<Integer>> list, ArrayList<Integer> temp) {

        if (src == destination) {
            ArrayList<Integer> curr = new ArrayList<>(temp);
            curr.add(src);
            list.add(curr);
            return;
        }
        if (visited[src]) return;

        visited[src] = true;
        temp.add(src);
        for (int nbr : graph.adj[src]) {
            if (!visited[nbr]) {
                helper(graph, nbr, destination, visited, list, temp);
            }
        }
        temp.remove(temp.size()-1);
        visited[src] = false;
    }
}
