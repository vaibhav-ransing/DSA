package NotDirectlyVisible;

import java.util.PriorityQueue;

public class TotalCostToHierKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int i = 0, j = n - 1;
        long ans_sum = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int idx = 0; idx < candidates; idx++) {
            if (i < j) {
                left.add(costs[i++]);
                right.add(costs[j--]);
            } else if (i == j) {
                left.add(costs[i++]);
            }
        }
        while (k-- > 0) {
            int lv = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int rv = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (lv <= rv) {  // if left val is smaller or equal get that val into answer an add next cost i.e. cost[i] if exist
                ans_sum += left.poll();
                if (i <= j) {
                    left.add(costs[i++]);
                }
            } else {
                ans_sum += right.poll();
                if (i <= j) {
                    right.add(costs[j--]);
                }
            }
        }
        return ans_sum;
    }

    // 4 8 6 1 5

}
