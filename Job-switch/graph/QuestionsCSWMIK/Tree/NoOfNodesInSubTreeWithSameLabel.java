package QuestionsCSWMIK.Tree;

import java.util.*;

public class NoOfNodesInSubTreeWithSameLabel {

    ArrayList<ArrayList<Integer>> graph;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[n];
        dfs(0, -1, labels, ans);
        return ans;
    }

    public int[] dfs(int src, int par, String label, int[] ans) {
        int[] freq = new int[26];

        for (int nbr : graph.get(src)) {
            if (nbr == par)
                continue;
            // get the fre of all the nbr below and add that into our current freq arr.
            int[] nbr_arr = dfs(nbr, src, label, ans);
            for (int i = 0; i < 26; i++) {
                freq[i] += nbr_arr[i];
            }
        }
        // increase the freq of character at current src i.e. index
        freq[label.charAt(src) - 'a']++;

        // ans[src] will be count of all the freq count at src.
        ans[src] = freq[label.charAt(src) - 'a'];

        return freq;
    }
}