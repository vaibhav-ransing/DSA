package Revision;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][]; // profit, capital
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { profits[i], capital[i] };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // profit, capitalReq

        int idx = 0;
        while (k > 0) {
            while (idx < n && arr[idx][1] <= w) {
                pq.add(arr[idx]);
                idx++;
            }
            if (pq.isEmpty())
                break;
            int[] peek = pq.remove();
            w += peek[0];
            k--;
        }
        return w;
    }
}
