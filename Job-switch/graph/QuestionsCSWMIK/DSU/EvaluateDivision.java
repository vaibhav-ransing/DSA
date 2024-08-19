package QuestionsCSWMIK.DSU;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            if (!map.containsKey(u))
                map.put(u, new HashMap<>());
            map.get(u).put(v, values[i]);
            if (!map.containsKey(v))
                map.put(v, new HashMap<>());
            map.get(v).put(u, 1.0 / values[i]);
        }

        double[] ans = new double[queries.size()];
        int idx = 0;
        for (List<String> query : queries) {
            String str = query.get(0);
            String dst = query.get(1);
            double val = dfs(str, dst, map, new HashSet<>());
            ans[idx++] = val < 0 ? -1 : val;
        }
        return ans;
    }

    public double dfs(String str, String dst, HashMap<String, HashMap<String, Double>> graph, HashSet<String> vis) {
        if (graph.containsKey(str) == false) {
            return -1;
        }
        if (str.equals(dst))
            return 1;
        vis.add(str);
        double ans = -1;
        for (String nbr : graph.get(str).keySet()) {
            if (vis.contains(nbr) == false) {
                ans = Math.max(ans, graph.get(str).get(nbr) * dfs(nbr, dst, graph, vis));
            }
        }
        return ans;
    }
}
