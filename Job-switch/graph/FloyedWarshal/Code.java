package FloyedWarshal;

public class Code {

    int INFY = 9999999;

    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        // If there is no edge mark it infy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = INFY;
                }
            }
        }

        // Now k will be the intermediate between i and j
        // start with k = 0 -> n and check if the dist btw i -> j is smaller of i -> k
        // then k -> j
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    // below wont work because we have edge from i -> j
                    // matrix[i][j] = Math.min(matrix[i][j], matrix[j][k] + matrix[k][i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INFY) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
