package QuestionsCSWMIK.DSU;

import java.util.HashMap;

public class MinCostWalkWtGraph {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU ds = new DSU(n);
        return null;
    }

    class DSU {

        int n;
        int[] parent;
        HashMap<Integer, Integer> map;  // root_parent, smallestEdge

        DSU(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;
            parent[xx] = yy;
        }
    }

}
