package QuestionsCSWMIK.DSU;

public class MostStonesRem {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU ds = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ds.union(i, j);
                }
            }
        }
        int leftStones = 0;

        for (int i = 0; i < ds.parent.length; i++) {
            if (ds.find(i) == i) {
                leftStones++;
            }
        }
        return n - leftStones;
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
