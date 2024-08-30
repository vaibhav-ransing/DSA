package QuestionsCSWMIK.ShortestPath;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>(); // src -> dst, bus

        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // src, bustIndex

        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j = 1; j < route.length; j++) {
                addGraph(graph, route[j - 1], route[j], i);
                if (j == route.length)
                    addGraph(graph, route[j], 0, i);
            }
        }

        while (queue.size() > 0) {
            int[] peek = queue.poll(); // dst, bus, count
            source = peek[0];
            int currBus = peek[1];
            int count = peek[2];
            if (visited.contains(source))
                continue;
            visited.add(source);
            if (source == target)
                return count;
            for (int nbr : graph.get(source).keySet()) {
                int nbrBus = graph.get(source).get(nbr);
                int newCount = nbrBus == currBus ? count : count + 1;
                queue.add(new int[] { nbr, nbrBus, newCount });
            }
        }
        return -1;
    }

    void addGraph(HashMap<Integer, HashMap<Integer, Integer>> graph, int src, int dst, int busNum) {
        if (graph.containsKey(src) == false)
            graph.put(src, new HashMap<>());
        graph.get(src).put(dst, busNum);
    }

}