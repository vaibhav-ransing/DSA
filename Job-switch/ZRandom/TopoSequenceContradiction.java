package ZRandom;

import java.util.*;

public class TopoSequenceContradiction {

    public boolean contradics(List<List<Integer>> sequences) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); // src -> <dts1, dst2>
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // vertex, in-count

        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                int src = seq.get(i - 1);
                int dst = seq.get(i);
                graph.putIfAbsent(src, new HashSet<>());
                graph.get(src).add(dst);
                inDegree.putIfAbsent(dst, 0);
                inDegree.putIfAbsent(src, 0);
                inDegree.put(dst, inDegree.getOrDefault(dst, 0) + 1);
            }
        }

        int visited = graph.size();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }
        while (queue.size() > 0) {
            int curr_size = queue.size();
            for (int i = 0; i < curr_size; i++) {
                visited--;
                int cv = queue.pop();
                for (int nbr : graph.get(cv)) {
                    inDegree.put(nbr, inDegree.get(nbr) - 1);
                    if (inDegree.get(nbr) == 0) {
                        queue.add(nbr);
                    }
                }
            }
        }
        return visited == 0;
    }
    // Friend A: 1, 3, 4, 2
    // Friend B: 3, 4, 9, 10
    // Friend C: 11, 49, 13, 3
    // Friend D: 19, 3, 13, 4
}
