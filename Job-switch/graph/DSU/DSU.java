package DSU;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DSU {

    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
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
        }else{
            parent[xx] = yy;
            size[yy] += size[xx];
        }
    }

    public static void main(String[] args) {

        DisjointSetRank ds = new DisjointSetRank(8);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        System.out.println(Arrays.toString(ds.size));
        System.out.println(Arrays.toString(ds.parent));

        if(ds.findParent(7) == ds.findParent(5)){
            System.out.println("yes");
        }

        System.out.println(Arrays.toString(ds.size));
        System.out.println(Arrays.toString(ds.parent));
    }
}