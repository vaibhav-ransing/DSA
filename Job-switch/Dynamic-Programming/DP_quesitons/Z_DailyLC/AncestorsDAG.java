package Z_DailyLC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class AncestorsDAG {
    List<List<Integer>> reverseGraph;
    HashSet<Integer>[] graphSet;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        reverseGraph = new ArrayList<>();
        graphSet = new HashSet[n];

        IntStream.range(0, n).forEach(i -> reverseGraph.add(new ArrayList<>()));
        IntStream.range(0, n).forEach(i -> graphSet[i] = new HashSet<>());

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            reverseGraph.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n]; // Reset visited for each node
            helper(i, i, visited);
        }

        List<List<Integer>> graphList = convertToList(graphSet);
        graphList.forEach(Collections::sort); // Sort each list of ancestors
        return graphList;
    }

    public static List<List<Integer>> convertToList(HashSet<Integer>[] graphSet) {
        List<List<Integer>> graphList = new ArrayList<>();
        for (HashSet<Integer> set : graphSet) {
            graphList.add(new ArrayList<>(set));
        }
        return graphList;
    }

    public void helper(int src, int parent, boolean[] visited) {
        if (visited[src]) {
            graphSet[parent].addAll(graphSet[src]);
            return;
        }
        visited[src] = true;
        if (src != parent)
            graphSet[parent].add(src);

        for (int nbr : reverseGraph.get(src)) {
            helper(nbr, parent, visited);
        }
    }
}
