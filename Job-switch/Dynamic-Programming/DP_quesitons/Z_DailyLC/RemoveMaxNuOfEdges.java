package Z_DailyLC;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveMaxNuOfEdges {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        DSU ds = new DSU(n + 1);

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                ds.union(edge[1], edge[2]);
            }
        }
        for (int[] edge : edges) {
            if (edge[0] != 3) {
                int u = edge[1];
                int v = edge[2];
                if (ds.find(u) == ds.find(v)){
                    count++;
                }
                ds.union(u, v);
            }
        }
        System.out.println(Arrays.toString(ds.parent));
        int parentOf1 = ds.find(1);
        for (int i = 2; i <= n; i++) {
            if(ds.find(i) != parentOf1){

                System.out.println(ds.find(i) +" "+ parentOf1);
            }
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
