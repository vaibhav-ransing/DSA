package DSU;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DisjointSetRank {

    int[] rank;
    int[] parent;
    int[] size;
    public DisjointSetRank(int n) {
        rank = new int[n+1];
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

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] > rank[ulp_v]) { // rank of u is more than v
            parent[ulp_v] = ulp_u;
        } else if (rank[ulp_u] < rank[ulp_v]) { // rank of v is more than u
            parent[ulp_u] = ulp_v;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] > size[ulp_v]) { // size of u is more than v
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            // size[ulp_v] = 0;
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }

    public static void main(String[] args) {
        int[][] array = {
                { 1, 2 },
                { 2, 3 },
                { 4, 5 },
                { 6, 7 },
                { 5, 6 },
                // { 3, 7 }
        };

        // DisjointSet ds = new DisjointSet(8);
        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);
        // ds.unionByRank(6, 7);
        // ds.unionByRank(5, 6);

        // System.out.println(Arrays.toString(ds.rank));
        // System.out.println(Arrays.toString(ds.parent));

        // if(ds.findParent(7) == ds.findParent(5)){
        //     System.out.println("yes");
        // }

        // System.out.println(Arrays.toString(ds.rank));
        // System.out.println(Arrays.toString(ds.parent));

        

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
