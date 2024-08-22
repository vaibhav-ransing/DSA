package QuestionsCSWMIK.Tree;

import java.util.ArrayList;

public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                graph.get(i).add(leftChild[i]);
            if (rightChild[i] != -1)
                graph.get(i).add(rightChild[i]);
        }
        boolean[] vis = new boolean[n];
        if (!dfs(0, vis, graph))
            return false;
        for (boolean val : vis) {
            if (!val)
                return false;
        }
        return true;
    }

    public boolean dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> graph) {
        if (vis[src])
            return false;
        vis[src] = true;
        boolean ans = true;
        if (graph.get(src).size() > 2)
            return false;
        for (int nbr : graph.get(src)) {
            ans = ans & dfs(nbr, vis, graph);
        }
        return ans;
    }

}
