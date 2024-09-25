package SweepLine.Random;

import java.util.*;

public class SkylineProblem {

    class Pair {
        int x;
        int ht;
        boolean isStart;
        int idx;

        Pair(int x, int ht, boolean isStart, int idx) {
            this.x = x;
            this.ht = ht;
            this.isStart = isStart;
            this.idx = idx;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            list.add(new Pair(b[0], b[2], true, i));
            list.add(new Pair(b[1], b[2], false, i));
        }
        Collections.sort(list, (a, b) -> a.x - b.x);

        int maxHt = 0;
        HashSet<Integer> set = new HashSet<>(); // idx
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // idx, ht

        for (int i = 0; i < list.size(); i++) {
            Pair curr = list.get(i);
            if (curr.isStart) {
                set.add(curr.idx);
                pq.add(new int[] { curr.idx, curr.ht });
            } else {
                set.remove(curr.idx);
                while (pq.size() > 0 && !set.contains(pq.peek()[0])) {
                    pq.poll();
                }
            }
            if (pq.size() == 0) {
                maxHt = 0;
                ans.add(new ArrayList<>(Arrays.asList(curr.x, 0)));
            } else {
                if (pq.peek()[1] != maxHt) {
                    System.out.println(pq.peek()[1] + " maxHt= " + maxHt);
                    maxHt = pq.peek()[1];
                    ans.add(new ArrayList<>(Arrays.asList(curr.x, maxHt)));
                }
            }
        }
        return ans;
    }
}

class Solution {
    class Pair {
        int x;
        int ht;
        boolean isStart;

        Pair(int x, int ht, boolean isStart) {
            this.x = x;
            this.ht = ht;
            this.isStart = isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Pair> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new Pair(b[0], b[2], true)); // Start of a building
            list.add(new Pair(b[1], b[2], false)); // End of a building
        }

        // Sort by x-coordinate, if equal x, sort by isStart and then by height
        Collections.sort(list, (a, b) -> {
            if (a.x != b.x)
                return a.x - b.x;
            if (a.isStart && b.isStart)
                return b.ht - a.ht; // Start with higher building first
            if (!a.isStart && !b.isStart)
                return a.ht - b.ht; // End with lower building first
            return a.isStart ? -1 : 1; // Start before end
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max-heap of heights
        pq.add(0); // Add a dummy ground height
        int prevMaxHt = 0;

        for (Pair curr : list) {
            if (curr.isStart) {
                // Add the new building's height
                pq.add(curr.ht);
            } else {
                // Remove the building's height
                pq.remove(curr.ht);
            }

            // Get the current max height
            int currMaxHt = pq.peek();

            // If the max height changes, add the critical point
            if (currMaxHt != prevMaxHt) {
                ans.add(new ArrayList<>(Arrays.asList(curr.x, currMaxHt)));
                prevMaxHt = currMaxHt;
            }
        }

        return ans;
    }
}
