package QuestionsCSWMIK.DFS;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> ans = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        // O(E)
        for (List<String> edge : tickets) {
            String src = edge.get(0);
            String dst = edge.get(1);
            if (!map.containsKey(src)) {
                // log(E)
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).add(dst);
        }
        dfs("JFK", map, ans);
        return ans;
    }

    // O(E log(E))
    public void dfs(String src, HashMap<String, PriorityQueue<String>> graph, List<String> ans) {
        while (graph.containsKey(src) && graph.get(src).size() > 0) {
            dfs(graph.get(src).poll(), graph, ans);
        }
        ans.add(0, src);
    }

}