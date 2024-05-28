package CompleBridgeArticlation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticulationPoint {
    
    
    int time;
    int[] low;
    int[] disc;
    boolean[] visited;


    public List<List<Integer>> articulatiopnPoint(int n, List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (List<Integer> edge : connections) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        time = 0;
        low = new int[n];
        disc = new int[n];
        visited = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(visited[i]==false){
                dfs(i, -1, graph, ans);
            }
        }
        return ans;
    }

    public int dfs()
}
