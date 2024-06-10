import java.util.Arrays;
import java.util.stream.IntStream;

public class Lc2101DetonateMaxBoms {

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        DSU ds = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p1[] = bombs[i];
                int p2[] = bombs[j];

                int x1 = p1[0];
                int y1 = p1[1];
                int dis1 = p1[2];

                int x2 = p2[0];
                int y2 = p2[1];
                int dis2 = p2[2];

                // int dis = (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
                int dis = (int) Math.hypot(x1 - x2, y1 - y2);
                int maxRange = Math.max(dis1, dis2);

                System.out.println(dis +" "+maxRange);

                if(maxRange >= dis){
                    ds.union(i, j);
                }
            }
        }
        // System.out.println(Arrays.toString(ds.parent));
        // System.out.println(Arrays.toString(ds.size));
        return Arrays.stream(ds.size).max().orElse(-1);
    }


    static class DSU {
        int parent[];
        int size[];

        DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
            Arrays.fill(size, 1);
        }

        int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pv == pu)
                return;

            parent[pv] = pu;
            size[pu] += size[pv];
            size[pv] = 0;

        }
    }
    
    public static void main(String[] args) {
        int[][] boms = {{0,0,5}, {0,6, 1}, {3, 0, 1}};
        maximumDetonation(boms);
    }
}
