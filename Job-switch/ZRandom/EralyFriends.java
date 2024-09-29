package ZRandom;

import java.util.*;
import java.util.stream.IntStream;

public class EralyFriends {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int count = 0;
        // a_ b_ c_ d_
        DSU ds = new DSU(n);
        for (int[] log : logs) {
            int currTime = log[0];
            int x = log[1];
            int y = log[2];
            count += ds.union(x, y);
            if (count == n - 1)
                return currTime;
        }
        return -1;
    }

    class DSU {
        int[] parent;
        int n;

        DSU(int n) {
            this.n = n;
            parent = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        int union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return 0;
            parent[xx] = yy;

            return 1;
        }
    }
}
