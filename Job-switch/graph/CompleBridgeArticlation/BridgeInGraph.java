package CompleBridgeArticlation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BridgeInGraph {

    int time;
    int[] low;
    int[] disc;
    boolean[] visited;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

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

    public int dfs(int src, int parent, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans) {

        visited[src] = true;
        time++;
        low[src] = time;  // we alter the low in the bewlow dfs
        disc[src] = time;  // once set it wont change

        for (int nbr : graph.get(src)) {
            if (visited[nbr]) {  // if nbr is already visited and it is now parent then get the low of that nbr
                if (nbr != parent) {
                    low[src] = Math.min(low[src], low[nbr]);
                }
            } else { // if not visited then go to that nbr get the minimum that nbr can get
                int lowNbr = dfs(nbr, src, graph, ans);
                low[src] = Math.min(low[src], lowNbr);
            }

            if (low[nbr] > disc[src]) {  // if the nbr minimum is greater than curr disc means there is no way for that nbr to connect to nodes above curr node so it is crirical bridge.
                List<Integer> temp = new ArrayList<>(Arrays.asList(src, nbr)); // src - nbr
                ans.add(temp);
            }
        }

        return low[src];
    }
}
