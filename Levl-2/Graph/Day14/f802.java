import java.util.*;
public class f802 {
    

    public List<Integer> eventualSafeNodes(int[][] graph) {
        vis = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            boolean isSafe = dfs2(graph, i);
            if(isSafe){
                ans.add(i);
            }
        }
        return ans;
    }
    static int[] vis;
    static boolean dfs2(int[][] graph,int src){
        if(vis[src]==1){
            return false;
        }else if(vis[src]==2){
            return true;
        }else{
            vis[src]=1;
            for(int nbr: graph[src]){
                boolean isSafe = dfs2(graph, nbr);
                if(isSafe==false){
                    return false;
                }
            }
        }
        vis[src] = 2;
        return true;
    }

}
