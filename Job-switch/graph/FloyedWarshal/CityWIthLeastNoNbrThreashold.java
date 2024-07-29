package FloyedWarshal;

import java.util.Arrays;

public class CityWIthLeastNoNbrThreashold {

    int INFY = 999999;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        Arrays.stream(mat).forEach(row -> Arrays.fill(row, INFY));
        for (int[] edge : edges) {
            mat[edge[0]][edge[1]] = edge[2];
            mat[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            mat[i][i] = 0;
        }

        // for every i -> j find the minimum distance
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        int min = INFY;
        int ans = -1;
        // Now check from i which all vertices can be rached within threashold and find
        // the minimun node ans
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}
