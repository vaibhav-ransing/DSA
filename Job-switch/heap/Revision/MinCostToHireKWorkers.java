package Revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {


    class Solution {

        // Exactly similar as MaxSubsedScore
        // Here we sort the array by ratio
        // now when we are at the i-th index, there the ratio will be maximum till that index
        // So it is totalQuality * ratio_i-th
        // (Q1 + Q2... + Qk) * Max(ratio_1, ratio_2, .... ratio_k)   || ratio = wi/ qi
        // here max means ratio_k will be asking more wage than ratio_k-1.. because it is sorted 
        // Now sice ratio is sorted ratio_i will be maximim and we want to keep trak of sum of quality
        // so when check all the possible combination with ratio_possible.
            // for Q keep the minimum k size Qt
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ans = Double.MAX_VALUE;
        
        // Create a list of workers with their quality, wage, and ratio
        List<double[]> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new double[]{quality[i], wage[i], (double) wage[i] / quality[i]});
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


    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double qi = quality[i];
            double wi = wage[i];
            double ratio = wi / qi;

            double temp = 0;
            PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                double qj = quality[j];
                double wj = wage[j];
                double wj_req = qj * ratio;
                if (wj <= wj_req) {
                    if (pq.size() < k - 1) {
                        pq.add(wj_req);
                        temp += wj_req;
                    } else if (pq.size() > 0 && pq.peek() > wj_req) {
                        temp -= pq.remove();
                        temp += wj_req;
                        pq.add(wj_req);
                    }
                }

                if (pq.size() == k - 1) {
                    ans = Math.min(temp, ans);
                }
            }
        }
        return ans;
    }
}
