import java.util.Arrays;
import java.util.HashSet;

public class NumberOfPossibleSetOfClossingBanch {

    class MyCodeBit {
        class Solution {
            public int numberOfSets(int n, int maxDistance, int[][] roads) {
                ans = 0;
                rec(0, n, maxDistance, roads, 0);
                return ans;
            }

            int ans = 0;

            public void rec(int idx, int n, int maxDistance, int[][] roads, int bitmask) {
                if (idx == n) {
                    ans += FloyedWarshal(roads, n, maxDistance, bitmask);
                    return;
                }

                // Include current index
                rec(idx + 1, n, maxDistance, roads, bitmask | (1 << idx));

                // Exclude current index
                rec(idx + 1, n, maxDistance, roads, bitmask);
            }

            public int FloyedWarshal(int[][] roads, int n, int maxDistance, int bitmask) {
                int mat[][] = new int[n][n];
                int MAX_VALUE = 9999999;

                // Initialize the matrix with MAX_VALUE, except for the diagonal
                for (int i = 0; i < n; i++) {
                    Arrays.fill(mat[i], MAX_VALUE);
                    mat[i][i] = 0;
                }

                // Update the matrix with the minimum weights for the edges in the subset
                for (int[] edge : roads) {
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    if (((bitmask >> u) & 1) == 1 && ((bitmask >> v) & 1) == 1) {
                        mat[u][v] = Math.min(mat[u][v], wt);
                        mat[v][u] = Math.min(mat[v][u], wt);
                    }
                }

                // Run Floyd-Warshall algorithm
                for (int k = 0; k < n; k++) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (mat[i][k] < MAX_VALUE && mat[k][j] < MAX_VALUE) {
                                mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                            }
                        }
                    }
                }

                // Check if any distance between two nodes is more than maxDistance
                for (int i = 0; i < n; i++) {
                    if (((bitmask >> i) & 1) == 1) {
                        for (int j = 0; j < n; j++) {
                            if (((bitmask >> j) & 1) == 1 && mat[i][j] > maxDistance) {
                                return 0;
                            }
                        }
                    }
                }
                return 1;
            }
        }

    }

    class MyCode {

        public int numberOfSets(int n, int maxDistance, int[][] roads) {
            ans = 0;
            rec(0, n, maxDistance, roads, new HashSet<>());
            return ans;
        }

        int ans = 0;

        public void rec(int idx, int n, int maxDistance, int[][] roads, HashSet<Integer> set) {
            if (idx == n) {
                ans += FloyedWarshal(roads, n, maxDistance, set);
                return;
            }

            // include
            set.add(idx);
            rec(idx + 1, n, maxDistance, roads, set);
            set.remove(idx);

            rec(idx + 1, n, maxDistance, roads, set);
        }

        // all the edges exclusing any u,v where u or v belong to ignored set.
        // if any edge is > maxDist in the matrix then it is not incluede
        public int FloyedWarshal(int[][] roads, int n, int maxDistance, HashSet<Integer> includeGroup) {
            int mat[][] = new int[n][n];
            int MAX_VALUE = 9999999;

            // Initialize the matrix with MAX_VALUE, except for the diagonal
            for (int i = 0; i < n; i++) {
                Arrays.fill(mat[i], MAX_VALUE);
                mat[i][i] = 0;
            }

            // Update the matrix with the minimum weights for the edges in the subset
            for (int[] edge : roads) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (includeGroup.contains(u) && includeGroup.contains(v)) {
                    mat[u][v] = Math.min(mat[u][v], wt);
                    mat[v][u] = Math.min(mat[v][u], wt);
                }
            }

            // Run Floyd-Warshall algorithm
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (mat[i][k] < MAX_VALUE && mat[k][j] < MAX_VALUE) {
                            mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                        }
                    }
                }
            }

            // Check if any distance between two nodes is more than maxDistance
            for (int i : includeGroup) {
                for (int j : includeGroup) {
                    if (mat[i][j] > maxDistance) {
                        return 0;
                    }
                }
            }
            return 1;
        }

    }
}