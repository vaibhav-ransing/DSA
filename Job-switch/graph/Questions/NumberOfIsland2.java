package Questions;
import java.util.stream.IntStream;

public class NumberOfIsland2 {

    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        DSU ds = new DSU(m * n);
        boolean[][] visit = new boolean[n][m];
        int[] ans = new int[q.length];

        int islandCount = 0;
        int idx = 0;
        for (int[] edge : q) {
            int row = edge[0];
            int col = edge[1];
            
            if (visit[row][col]){
                ans[idx++] = islandCount;
                continue;
            }
            visit[row][col] = true;
            islandCount++;  // consier this as individual contributer

            int node = row * m + col;
            
            int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

            for (int d[] : dir) {
                int rr = row + d[0];
                int cc = col + d[1];
                
                if (rr < 0 || rr >= n || cc < 0 || cc >= m || visit[rr][cc] == false)
                    continue;

                if (ds.find(node) != ds.find(rr * m + cc)) { // if node does not have same parent that means it is connecting to new islands
                    islandCount--; 
                }
                ds.union(node, rr * m + cc);
            }
            ans[idx++] = islandCount;
        }
        return ans;
    }

    static class DSU {

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

    // < --------------------------------- Island 1
    // ------------------------------------ >

    char[][] grid;
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        grid = mat;

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j);

                }
            }
        }
        return ans;
    }

    public void dfs(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        for (int d[] : dir) {
            int rr = d[0] + row;
            int cc = d[1] + col;
            dfs(rr, cc);
        }
    }

}
