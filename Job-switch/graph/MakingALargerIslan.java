import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class MakingALargerIslan {

    public int largestIsland(int[][] grid) { // n x n
        int n = grid.length;
        DSU ds = new DSU(n * n);

        boolean[][] visited = new boolean[n][n];
        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {

                    visited[row][col] = true;
                    int node = row * n + col;

                    for (int d[] : dir) {
                        int rr = row + d[0];
                        int cc = col + d[1];
                        int nodeNbr = rr * n + cc;

                        if (rr < 0 || rr >= n || cc < 0 || cc >= n || visited[rr][cc] == false || grid[rr][cc] == 0)
                            continue;
                        if (ds.find(node) != ds.find(nodeNbr)) {
                            ds.union(node, nodeNbr);
                        }
                    }
                }
            }
        }

        int size = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int currSize = 1;
                    HashSet<Integer> visisted = new HashSet<>();
                    for (int d[] : dir) {
                        int rr = row + d[0];
                        int cc = col + d[1];

                        if (rr < 0 || rr >= n || cc < 0 || cc >= n || grid[rr][cc] == 0)
                            continue;
                        int currNbrNode = rr * n + cc;
                        int parent = ds.find(currNbrNode);
                        if (visisted.contains(parent))
                            continue;
                        visisted.add(parent);
                        currSize += ds.getSize(parent);
                    }
                    size = Math.max(size, currSize);
                } else {
                    size = Math.max(size, ds.getSize(row * n + col));
                }
            }
        }
        return size;

    }

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        int getSize(int x) {
            int parent = find(x);
            return size[parent];
        }

        void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx == yy)
                return;

            if (size[xx] > size[yy]) {
                parent[yy] = xx;
                size[xx] += size[yy];
                size[yy] = 0;
            } else {
                parent[xx] = yy;
                size[yy] += size[xx];
                size[xx] = 0;
            }
        }

    }
}
