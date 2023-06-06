package Course.Graph.Day13_DSU;

import java.util.Arrays;

public class NumberOfIsland_547 {

    class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }

        boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return false;

            if(rank[pa] > rank[pb]){
                parent[pb] = pa;
                rank[pa] += rank[pb];
            }else{
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
            return true;
        }

        int find(int x){
            if(parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int components = n;

        DSU dsu = new DSU(n);

        for(int src=0; src<n; src++){
            for(int dest = src+1; dest<n; dest++){
                if(isConnected[src][dest] ==0 ) continue;
                if(dsu.union(src, dest)){
                    components--;
                }
            }
        }
        return components;
    }

}
