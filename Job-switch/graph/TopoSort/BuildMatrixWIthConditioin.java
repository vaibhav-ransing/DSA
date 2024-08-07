import java.util.ArrayList;
import java.util.Stack;

public class BuildMatrixWIthConditioin {

    ArrayList<ArrayList<Integer>> rowGraph = new ArrayList<>();
    ArrayList<ArrayList<Integer>> colGraph = new ArrayList<>();

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        buildGraphs(k, rowConditions, colConditions);

        Stack<Integer> stackRow = new Stack<>();
        Stack<Integer> stackCol = new Stack<>();

    }

    void topo(int src, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> graph) {
        if (visited[src])
            return;
        visited[src] = true;
        for (int nbr : graph.get(src)) {
            topo(nbr, visited, stack, graph);
        }
        stack.add(src);
    }

    void buildGraphs(int k, int[][] rowConditions, int[][] colConditions) {
        for (int i = 0; i < k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }
        for (int[] edge : rowConditions) {
            rowGraph.get(edge[0] - 1).add(edge[1] - 1);
        }
        for (int[] edge : colConditions) {
            colGraph.get(edge[0] - 1).add(edge[1] - 1);
        }
    }
}
