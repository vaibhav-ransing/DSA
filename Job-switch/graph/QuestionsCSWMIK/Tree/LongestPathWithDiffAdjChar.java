package QuestionsCSWMIK.Tree;

import java.util.ArrayList;

public class LongestPathWithDiffAdjChar {

    ArrayList<ArrayList<Integer>> graph;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            int par = parent[i];
            graph.get(i).add(par);
            graph.get(par).add(i);
        }
        dfs(0, -1, s);
        return ans;
    }

    int ans = 0;

    public int dfs(int src, int par, String str) {

        int max1 = 0;
        int max2 = 0;

        for (int nbr : graph.get(src)) {
            if (nbr == par)
                continue;

            int left = 0;
            if (str.charAt(nbr) == str.charAt(src)) {
                dfs(nbr, src, str);
            } else {
                left = dfs(nbr, src, str);
            }
            if (max1 < left) {
                max2 = max1;
                max1 = left;
            } else if (max2 < left) {
                max2 = left;
            }

        }
        ans = Math.max(ans, max1 + max2);

        return max1 + 1;
    }

}