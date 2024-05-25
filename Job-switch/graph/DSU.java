
import java.util.Arrays;
import java.util.stream.IntStream;

public class DSU {

    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        IntStream.range(0, n).forEach(i -> parent[i] = i);
        Arrays.fill(size, 1);
    }

    public int findParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void unionBySize(int x, int y) {
        int xx = findParent(x);
        int yy = findParent(y);
        if (xx == yy)
            return;

        if (size[xx] > size[yy]) { // size of u is more than v
            parent[yy] = xx;
            size[xx] += size[yy];
            // size[yy] = 0;
        } else {
            parent[xx] = yy;
            size[yy] += size[xx];
        }
    }
}