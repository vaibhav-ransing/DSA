package Questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FindEventualSafeStates {

    static boolean[] visited;
    static boolean[] trackPath;
    static boolean[] check;

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        visited = new boolean[n];
        trackPath = new boolean[n];
        check = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            if(visited[i] == false){
                dfs(i, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<check.length; i++){
            if(check[i]) ans.add(i);
        }
        System.out.println(ans);
        return ans;
    }

    public static boolean dfs(int src, int[][] graph) {

        if (trackPath[src]) return false;
        if (visited[src]) return check[src];  // I was returning true so was geetin wrong ans.

        visited[src] = true;
        trackPath[src] = true;

        boolean ans = true;
        for (int nbr : graph[src]) { // traverse through all nbr nodes if any one of them has cycle then src cannot be safe node.
            boolean flag = dfs(nbr, graph);
            ans = ans && flag;
        }

        trackPath[src] = false;  // make sure to do this, else it will become like undirected graph.
        return check[src] = ans;
    }

    
    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        eventualSafeNodes(graph);
    }
}
