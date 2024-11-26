package AALastGo.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {

    class Solution {

        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            double ans = Double.MAX_VALUE;

            // Create a list of workers with their quality, wage, and ratio
            List<double[]> workers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                workers.add(new double[] { quality[i], wage[i], (double) wage[i] / quality[i] });
            }

            // Sort workers by their ratio of wage to quality
            workers.sort((a, b) -> Double.compare(a[2], b[2]));

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int totalQuality = 0;

            for (int i = 0; i < n; i++) {
                double[] worker = workers.get(i);
                int q = (int) worker[0];
                double r = worker[2];

                // Add the current worker's quality to the total quality and priority queue
                pq.add(q);
                totalQuality += q;

                // If we have more than k workers, remove the one with the highest quality
                if (pq.size() > k) {
                    totalQuality -= pq.poll();
                }

                // If we have exactly k workers, calculate the minimum cost
                if (pq.size() == k) {
                    ans = Math.min(ans, r * totalQuality);
                }
            }

            return ans;
        }
    }
}
