package FloyedWarshal;

import java.util.ArrayList;
import java.util.Arrays;

public class CountNoHousesAtCertainDist {

    class Solution {
        public int[] countOfPairs(int n, int x, int y) {

            int[][] mat = new int[n][n];
            int MAX_VALUE = 99999;
            Arrays.stream(mat).forEach(row -> Arrays.fill(row, MAX_VALUE));
            for (int i = 0; i < n - 1; i++) {
                mat[i][i + 1] = 1;
                mat[i + 1][i] = 1;
            }

            // Set the edge between nodes x and y
            mat[x - 1][y - 1] = 1;
            mat[y - 1][x - 1] = 1;

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
            final int[] total = new int[n];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    if (i != j)
                        total[mat[i][j] - 1]++;

            return total;
        }
    }

}
