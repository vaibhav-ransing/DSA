import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length + 1;
        boolean[] visited = new boolean[n];

        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                ans += 1;
                dfs(isConnected, i, visited);
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, int row, boolean[] visited) {

        visited[row] = true;
        for (int col = 0; col < isConnected.length; col++) {
            if (col != row && isConnected[row][col] == 1 && !visited[col]) {
                dfs(isConnected, col, visited);
            }
        }
    }
    // <-------------------------- DSU -------------------------------->

    public int findCircleNumDsu(int[][] isConnected) {
        int n = isConnected.length;
        int components = n;

        DSU dsu = new DSU(n);

        for (int src = 0; src < n; src++) {
            for (int dest = src + 1; dest < n; dest++) {
                if (isConnected[src][dest] == 0)
                    continue;
                if (dsu.union(src, dest)) {
                    components--;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < dsu.parent.length; i++) {
            if (set.contains(dsu.find(i)) == false)
                set.add(dsu.parent[i]);
        }
        System.out.println(Arrays.toString(dsu.parent));
        return set.size() - 1;
    }

    class DSU {
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

        public boolean union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return false;
            parent[yy] = xx;
            return true;
        }
    }

    // <-------------------------- BFS -------------------------------->
    public void bfs(int node, int[][] isConnected, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public int findCircleNumBFS(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                bfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

}
