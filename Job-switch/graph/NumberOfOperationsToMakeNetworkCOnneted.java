import java.util.stream.IntStream;

public class NumberOfOperationsToMakeNetworkCOnneted {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        DSU ds = new DSU(n);

        for (int[] edge : connections) {
            ds.union(edge[0], edge[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i)
                count++;
        }
        return count - 1;
    }

    class DSU {

        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;
            parent[yy] = xx;
        }
    }
}
