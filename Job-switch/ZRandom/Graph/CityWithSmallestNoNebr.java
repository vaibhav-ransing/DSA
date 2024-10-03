package ZRandom.Graph;

import java.util.Arrays;

public class CityWithSmallestNoNebr {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        Arrays.stream(mat).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE / 3));
        for (int i = 0; i < n; i++) {
            mat[i][i] = 0;
        }
        for (int[] edge : edges) {
            mat[edge[0]][edge[1]] = edge[2];
            mat[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
    }
}
