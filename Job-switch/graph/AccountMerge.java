import java.util.*;
import java.util.stream.IntStream;

public class AccountMerge {
    public class DSU {

        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;
            parent[yy] = xx;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<Integer, TreeSet<String>> map = new HashMap<>();
        int n = accounts.size();

        for (int i = 0; i < n; i++) {
            List<String> currList = accounts.get(i);
            map.put(i, new TreeSet<>()); // Initialize TreeSet for each index
            for (int j = 1; j < currList.size(); j++) {
                map.get(i).add(currList.get(j));
            }
        }

        DSU ds = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<String> currList = accounts.get(j);
                    for (String acc : currList) {
                        if (map.get(i).contains(acc)) { // email in j-th row is prenet in i-th row
                            ds.union(i, j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int parentIdx = ds.find(i);
            if (parentIdx != i) {
                TreeSet<String> curAcc = map.get(i);
                if (curAcc != null) {
                    map.get(parentIdx).addAll(curAcc);
                    map.remove(i); // Remove merged child map
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (int idx : map.keySet()) {
            String personName = accounts.get(idx).get(0);
            List<String> currList = new ArrayList<>(map.get(idx));
            currList.add(0, personName);
            ans.add(currList);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("cc");
        set.add("aa");
        set.add("ca");
        for (String val : set) {
            System.out.println(val);
        }
    }
}
