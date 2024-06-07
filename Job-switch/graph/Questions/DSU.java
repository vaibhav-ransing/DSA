package Questions;

import java.util.stream.IntStream;

public class DSU {

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