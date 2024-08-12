package QuestionsCSWMIK.DSU;

public class FindPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU ds = new DSU(n);
        for(int[] edge : edges){
            ds.union(edge[0], edge[1]); 
        }
        return ds.find(source) == ds.find(destination);
    }

    class DSU {

        int n;
        int[] parent;

        DSU(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;
            parent[xx] = yy;
        }
    }
}
