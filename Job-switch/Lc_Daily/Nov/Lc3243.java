package Lc_Daily.Nov;

import java.util.Arrays;

public class Lc3243 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = i;
        }
        // 0 1 2 3 4
        int m = queries.length;
        int[] ans = new int[m];
        System.out.println(Arrays.toString(dis));
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int u = query[0];
            int v = query[1];
            if (u > v)
                continue;
            int diff = v - u;
            for (int j = v; j < m; j++) {
                dis[j] -= diff;
            }
            System.out.println(Arrays.toString(dis));
            ans[i] = dis[m - 1];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
