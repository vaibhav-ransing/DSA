package AALastGo.Heap;

import java.util.*;

public class SingleThreadCpu {
    public int[] getOrder(int[][] tasks) {
        int[][] arr = new int[tasks.length][];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);  

        // Prepare the task array with enqueue time, processing time, and index
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            arr[i] = new int[] { task[0], task[1], i }; // Enqueue time, processing time, index
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // Sort by enqueue time

        int[] ans = new int[tasks.length];
        int aid = 0;

        int timeElapsed = 0;
        int idx = 0;

        while (aid < tasks.length) {
            // If no tasks can be processed, fast-forward time
            if (idx < arr.length && pq.isEmpty() && arr[idx][0] > timeElapsed) {
                timeElapsed = arr[idx][0];
            }

            // Add all tasks available at the current time
            while (idx < arr.length && arr[idx][0] <= timeElapsed) {
                pq.add(arr[idx]);
                idx++;
            }

            // Process the next task
            int[] currTask = pq.remove(); // Remove the task with the shortest processing time
            int timeToExecute = currTask[1];
            timeElapsed += timeToExecute;

            ans[aid++] = currTask[2]; // Record the task index
        }
        return ans;
    }
}
