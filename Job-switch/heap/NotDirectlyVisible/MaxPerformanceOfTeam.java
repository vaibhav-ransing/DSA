package NotDirectlyVisible;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { speed[i], efficiency[i] };
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        long sum = 0;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // engineer with max speed
        // loop on array
        for (int i = 0; i < n; i++) {
            int spd = arr[i][0];
            int min_eff = arr[i][1];
            sum += spd;
            pq.add(spd);

            if (pq.size() > k) {
                sum -= pq.remove();
            }
            ans = Math.max(ans, sum * min_eff);  // at most k elements 
        }
        return (int)(ans % 1000000007);
    }

    public static void main(String[] args) {
        int[] speed = { 2, 8, 2 };
        int[] efficiency = { 2, 7, 1 };
        int n = 3, k = 2;

        maxPerformance(n, speed, efficiency, k);
    }
}
