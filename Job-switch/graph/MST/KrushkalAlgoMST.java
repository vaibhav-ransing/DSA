package MST;

import java.util.*;
import java.util.stream.IntStream;

public class KrushkalAlgoMST {

    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        public Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int getMinimumCost(int n, int m, int[][] connections) {
        n = n + 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] edge : connections) {
            int x = edge[0];
            int y = edge[1];
            int wt = edge[2];
            pq.add(new Pair(x, y, wt));
        }
        DSU ds = new DSU(n);
        int ans = 0;

        while (pq.size() > 0) {
            Pair peek = pq.remove();
            int u = peek.u;
            int v = peek.v;
            int wt = peek.wt;

            if (ds.findParent(u) != ds.findParent(v)) { // means they are not part of mst yet
                ans += wt;
                n--;
            }
            ds.unionNeeded(u, v);
        }
        return n > 2 ? -1 : ans;
    }

    
    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
            Arrays.fill(size, 1);
        }

        int findParent(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = findParent(parent[x]);
        }

        void unionNeeded(int x, int y) {

            int xx = findParent(x);
            int yy = findParent(y);
            if (xx == yy)
                return;

            if (size[xx] > size[yy]) {
                parent[yy] = xx;
                size[xx] += size[yy];
            } else {
                parent[xx] = yy;
                size[yy] += size[xx];
            }
        }

    }

}