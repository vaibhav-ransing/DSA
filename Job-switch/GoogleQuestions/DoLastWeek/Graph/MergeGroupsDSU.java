package DoLastWeek.Graph;

import java.util.*;
import java.util.stream.IntStream;

public class MergeGroupsDSU {

    // You're given a list of elements. Each element has a unique id and 3
    // properties. Two elements are considered as duplicates if they share any
    // of the 3 properties. Please write a function that takes the input and returns
    // all the duplicates.

    // Input:
    // E1: id1, p1, p2, p3
    // E2: id2, p1, p4, p5
    // E3: id3, p6, p7, p8

    // Output: {{id1, id2}, {id3}}

    // Input:
    // E1: id1, p1, p2, p3
    // E2: id2, p1, p4, p5
    // E3: id3, p5, p7, p8

    // Output: {{id1, id3, id3}}

    public static void soln(List<List<String>> list) {
        DSU ds = new DSU(list.size());

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> temp = list.get(i);
            for (int j = 1; j < temp.size(); j++) {
                String prop = temp.get(j);
                if (!map.containsKey(prop)) {
                    map.put(prop, new ArrayList<>());
                }
                List<Integer> idList = map.get(prop);
                for (int id : idList) {
                    ds.union(i, id);
                }
                map.get(prop).add(i);
            }
        }
        System.out.println(Arrays.toString(ds.parent));
    }

    static class DSU {
        int parent[];

        DSU(int n) {
            this.parent = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pv == pu)
                return;
            parent[pv] = pu;
        }
    }

}