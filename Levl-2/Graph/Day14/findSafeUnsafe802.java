import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findSafeUnsafe802 {
    


    public static List<Integer> eventualSafeNodes(int[][] graph) {
        vis = new boolean[graph.length];
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] ans = new boolean[graph.length];
        Arrays.fill(ans, true);
        for(int i=0; i<graph.length; i++){
            boolean isSafe = dfs(graph, i);
            if(isSafe==false ){
                ans[i] = false;
            }
        }
        for(int i=0; i<ans.length; i++){
            if(ans[i]){
                al.add(i);
            }
        }
        return al;
    }
    static boolean vis[];
    static boolean dfs(int[][] graph, int src){
        if(vis[src]==true){
            return false;
        }
        vis[src] = true;
        boolean isSafe = true;
        for(int nbr: graph[src]){
            boolean nbrSafe = dfs(graph, nbr);
            if(nbrSafe==false){
                isSafe =  false;
            }
        }
        vis[src] = false;
        return isSafe;
    }






    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     int n = graph.length;
    //     boolean[] visited = new boolean[graph.length];
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i=0; i<n;i++){
    //         ans.add(i);
    //     }
    //     for(int i=0; i<graph.length; i++){
    //         dfs(graph,i, i, ans, visited);
    //     }
    //     return ans;
    // }
    // static boolean dfs(int[][] graph,int initialSrc, int src, List<Integer> ans, boolean[] visited){
    //     if(visited[src]){
    //         return false;
    //     }
    //     visited[src] = true;
    //     boolean isSafe = true;
    //     for(int nbr: graph[src]){
    //         System.out.println(src+" "+initialSrc);
    //         boolean temp = dfs(graph,initialSrc, nbr, ans, visited);
    //         if(temp==false){
    //             isSafe= false;
    //         }
    //         System.out.println(src+" "+initialSrc+" "+temp);
    //         System.out.println("-----------");
    //     }
    //     visited[src] = false;
    //     if(isSafe==false && ans.contains(src)){
    //         ans.remove(src);
    //     }
    //     return isSafe;
    // }
    




    // static int[] vis;
    // public static List<Integer> eventualSafeNodes(int[][] graph) {
    //     vis = new int[graph.length];
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     for(int i=0;i<graph.length; i++){
    //         boolean isSafe = dfs(graph, i);
    //         if(isSafe){
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }
    // static boolean dfs(int[][] graph, int src){
    //     if(vis[src]==1){
    //         return false;
    //     }else if(vis[src]==2){
    //         return true;
    //     }
    //     vis[src]=1;
    //     for(int nbr: graph[src]){
    //         boolean isSafeNbr = dfs(graph, nbr);
    //         if(isSafeNbr==false){
    //             return false;
    //         }
    //     }
    //     vis[src]=2;
    //     return true;
    // }





    public static void main(String[] args) {
        int graph[][]= {{0},{2,3,4},{3,4},{0,4},{}};
        eventualSafeNodes(graph);
    }
}
