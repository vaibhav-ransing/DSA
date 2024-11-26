package AALastGo.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class AccountMergeDSU {

    public class MergeGroupsDSU {

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
}
