package QuestionsCSWMIK.DSU;

public class LexicographicallySmallestEqivalentString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU ds = new DSU();
        for (int i = 0; i < s1.length(); i++) {
            ds.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int par = ds.find(ch - 'a');
            char character = (char) ('a' + par);
            System.out.println(character);
            sb.append((char) par + 'a');
        }
        return sb.toString();
    }

    class DSU {

        int[] parent;

        DSU() {
            int n = 26;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;
            if (xx < yy)
                parent[yy] = xx;
            else
                parent[xx] = yy;
        }
    }

}