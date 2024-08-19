package QuestionsCSWMIK.DSU;

import java.util.Arrays;

public class CheckingExistenceEdgeLengthLimitedPaths {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        boolean[] ans = new boolean[queries.length];
        DSU ds = new DSU(n);
        int[][] queriesWithIndex = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i][0]; // i
            queriesWithIndex[i][1] = queries[i][1]; // j
            queriesWithIndex[i][2] = queries[i][2]; // weight (limit)
            queriesWithIndex[i][3] = i;             // original index
        }
        Arrays.sort(queriesWithIndex, (a,b) -> a[2]-b[2]);
        int idx = 0;
        for (int i = 0; i < queriesWithIndex.length; i++) {
            int x = queriesWithIndex[i][0];
            int y = queriesWithIndex[i][1];
            int limit = queriesWithIndex[i][2];

            while (idx < edgeList.length && edgeList[idx][2] < limit) {
                ds.union(edgeList[idx][0], edgeList[idx][1]);
                idx++;
            }
            ans[queriesWithIndex[i][3]] = ds.find(x) == ds.find(y);
        }
        return ans;
    }

    class DSU {

        int n;
        int[] parent;

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