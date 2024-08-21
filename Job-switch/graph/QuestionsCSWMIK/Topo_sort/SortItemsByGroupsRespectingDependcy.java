package QuestionsCSWMIK.Topo_sort;

import java.util.*;

public class SortItemsByGroupsRespectingDependcy {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(n, beforeItems);
        ArrayList<HashSet<Integer>> listGroup = new ArrayList<>();

        for (int i = 0; i < group.length; i++) {
            if (group[i] != -1) {
                listGroup.get(group[i]).add(i);
            }
        }
        return null;
    }

    public ArrayList<ArrayList<Integer>> buildGraph(int n, List<List<Integer>> beforeItems) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < beforeItems.size(); i++) {
            for (int par : beforeItems.get(i)) {
                graph.get(par).add(i);
            }
        }
        return graph;
    }

}