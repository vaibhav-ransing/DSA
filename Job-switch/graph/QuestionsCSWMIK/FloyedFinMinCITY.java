import java.util.Arrays;

public class FloyedFinMinCITY {
    int[][] dis;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 10000 is the highest weight according to constraints
            Arrays.fill(dis[i], 10001);
            // For same node
            dis[i][i] = 0;
        }
        for (int[] edge : edges) {
            // Since, edges are biderectional
            dis[edge[0]][edge[1]] = edge[2];
            dis[edge[1]][edge[0]] = edge[2];
        }
        floydWarshall();
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= min) {
                min = count;
                res = i;
            }
        }
        return res;
    }

    private void floydWarshall() {
        int n = dis.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
    }
}
