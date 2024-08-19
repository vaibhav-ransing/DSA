package QuestionsCSWMIK.Trick;

import java.util.ArrayList;
import java.util.List;

public class MinNoVerticesToReachALlNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}
