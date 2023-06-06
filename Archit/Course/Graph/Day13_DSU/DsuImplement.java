package Course.Graph.Day13_DSU;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DsuImplement{

    class DSU{
        // inverse accerman constant which is 4

        int parent[];
        int rank[];

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            Arrays.fill(rank, 1);
            Arrays.fill(parent, -1);
            
            // for(int i=0; i<n; i++){
            //     parent[i] = i;
            // }
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

    class DSU_NotOptmised{

        int parent[];

        DSU_NotOptmised(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            parent[pa] = pb;
        }

        int find(int x){
            if(parent[x] == -1) return x;
            return find(parent[x]);
        }
    }


    public static void main(String[] args) {
        
    }
}