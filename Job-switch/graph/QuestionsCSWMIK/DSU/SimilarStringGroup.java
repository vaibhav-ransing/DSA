package QuestionsCSWMIK.DSU;

import java.util.HashSet;

public class SimilarStringGroup {

    public int numSimilarGroups(String[] strs) {
        DSU ds = new DSU(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSame(strs[i], strs[j])) {
                    ds.union(i, j);
                }
            }
        }
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < ds.n; i++) {
            if (!set.contains(ds.find(i))) {
                set.add(ds.find(i));
                count++;
            }
        }
        return count;
    }

    class DSU {

        int n;
        int[] parent;

        DSU(int n) {
            this.n = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            parent[find(x)] = parent[find(y)];
        }
    }

    public boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int diffCount = 0;
        int difIdx1 = -1;
        int difIdx2 = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount == 0) {
                    difIdx1 = i;
                } else if (diffCount == 1) {
                    difIdx2 = i;
                }
                diffCount++;
            }
        }
        if(diffCount == 0) return true;
        if (diffCount == 2) {
            return s1.charAt(difIdx1) == s2.charAt(difIdx2) && s1.charAt(difIdx2) == s2.charAt(difIdx1);
        }

        return false;
    }

}
