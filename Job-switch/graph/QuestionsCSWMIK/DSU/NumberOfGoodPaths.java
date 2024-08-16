package QuestionsCSWMIK.DSU;

import java.util.Arrays;

public class NumberOfGoodPaths {
    
    // https://leetcode.com/problems/number-of-good-paths/description/
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        return 0;
    }

    class DSU {

        int[] count;
        int n;
        int[] parent;

        DSU(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(count, 1);
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public int union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return 0;
            parent[xx] = yy;
            return 0;
        }
    }

}
