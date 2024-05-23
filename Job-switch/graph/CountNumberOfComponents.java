import java.util.ArrayList;
import java.util.Arrays;

public class CountNumberOfComponents {

    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> temp : graph) {
            System.out.println(temp);
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean valid = helper(graph, i, visited, graph.get(i).size());
                if (valid)
                    ans++;
            }
            System.out.println(Arrays.toString(visited));
        }
        return ans;
    }

    public boolean helper(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited, int count) {
        if (visited[idx])
            return true;
        if (graph.get(idx).size() != count)
            return false;

        visited[idx] = true;
        boolean ans = true;
        for (int nbr : graph.get(idx)) {
            ans &= helper(graph, nbr, visited, count);
        }
        return ans;
    }
}
