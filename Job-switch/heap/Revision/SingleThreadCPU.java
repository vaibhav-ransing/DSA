package Revision;

import java.util.*;

public class SingleThreadCPU {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];

        ArrayList<int[]> list = new ArrayList<>(); // start, TimeTaken, index
        for (int i = 0; i < n; i++) {
            list.add(new int[] { tasks[i][0], tasks[i][1], i });
        }
        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });

        // start, timeTaken, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        int prevEndTime = 0;
        int idx = 0, ansIdx = 0;

        while (!pq.isEmpty() || idx < n) {
            // tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
            // for the above we 7 is start and all the tasks with 7 start should be pushed.
            // that's why we cannot keep this
            if (pq.isEmpty()) {
                prevEndTime = Math.max(prevEndTime, list.get(idx)[0]);
            }

            while (idx < n && list.get(idx)[0] <= prevEndTime) {
                pq.add(list.get(idx++));
            }

            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                ans[ansIdx++] = curr[2];
                prevEndTime += curr[1];
            }
        }
        return ans;
    }
}