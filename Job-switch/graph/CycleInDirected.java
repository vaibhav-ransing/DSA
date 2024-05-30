import java.util.ArrayList;
import java.util.stream.IntStream;

public class CycleInDirected {

    static boolean[] visited;
    static boolean[] trackPath;

    public static boolean canFinish(int n, int[][] prerequisites) {
        visited = new boolean[n];
        trackPath = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(dfs(i, graph)) return false;
            }
        }
        return true;
    }

    public static boolean dfs(int src, ArrayList<ArrayList<Integer>> graph){
        if(trackPath[src]){
            return true;
        }
        if(visited[src]) return false;

        visited[src] = true;
        trackPath[src] = true;

        boolean ans = false;
        
        for(int nbr : graph.get(src)){
            // if(visited[nbr] == false){  // this line is breaking code ;)
                ans = ans || dfs(nbr, graph);
            // }
        }
        trackPath[src] = false;
        return ans;
    }
    

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        n = n+1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }

        visited = new boolean[n];
        trackPath = new boolean[n];

        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(dfs(i, graph)) return true;
            }
        }
        return false;
    }

}
