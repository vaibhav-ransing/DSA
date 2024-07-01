package Z_DailyLC;
import java.util.Arrays;
import java.util.stream.IntStream;

public class REmMaxEdges {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice1 = new DSU(n + 1);
        DSU bob2 = new DSU(n + 1);

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                alice1.union(edge[1], edge[2]);
                bob2.union(edge[1], edge[2]);
            }
        }
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            if (edge[0] == 1) { // alice
                if (alice1.find(u) != alice1.find(v)) {
                    alice1.union(u, v);
                }else{  // already connected, not needed edge so remove it
                    count++;
                }
            } else if (edge[0] == 2) { // bob
                if (bob2.find(u) != bob2.find(v)) {
                    bob2.union(u, v);
                }else{
                    count++;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (bob2.find(i) != bob2.find(i - 1) || alice1.find(i) != alice1.find(i - 1))
                return -1;
        }
        return count;
    }

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv)
                return;
            parent[pu] = pv;
        }
    }
}
