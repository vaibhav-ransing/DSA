import java.util.ArrayDeque;

public class redundantConection684 {
    
    static int[] parent;
    static int[] rank;

    public static int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        int ans[] = new int[2];
        // for(int[] edge: edges){
        for(int i=0 ;i<edges.length; i++){
            parent[i]=i;
        }
        for(int i=0 ;i<edges.length; i++){
            int[] edge = edges[i];
            int x = find(edge[0]);
            int y = find(edge[1]);
            System.out.println(x+" "+y);
            if(x!=y){
                union(x, y);
            }else{
                ans[0] = edge[0];
                ans[1] = edge[1];
                break;
            }
        }
        return ans;
    }
   
    public static int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public static void union(int s1l, int s2l){
        if(rank[s1l] < rank[s2l]){
            parent[s1l] = s2l;
        } else if(rank[s2l] < rank[s1l]){
            parent[s2l] = s1l;
        } else {
            parent[s1l] = s2l;
            rank[s2l]++;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        findRedundantConnection(edges);
    }
}
