package Course.Graph.Day13_DSU;

import java.util.Arrays;

public class NumberOfComp2d {
    
    class DSU{
        int parent[];
        int rank[];

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            Arrays.fill(rank, 1);
            Arrays.fill(parent, -1);
        }
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }else{
                parent[pb] = pa;
                rank[pa] += rank[pb]; 
            }
        }
        int find(int x){
            if(parent[x] == -1) return x;
            return parent[x] =  find(parent[x]);
        }
    }

    public int numIslands(char[][] grid) {
        int comp = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == 1) comp++;
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                
            }
        }
    }




    public static void main(String[] args) {
        
    }
}
