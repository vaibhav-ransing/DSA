package Basics;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopK_FrequentElements {

    class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (int key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new Pair(key, map.get(key)));
            } else {
                if (minHeap.peek().freq < map.get(key)) {
                    minHeap.remove();
                    minHeap.add(new Pair(key, map.get(key)));
                }
            }
        }
        int[] ans = new int[k];
        int idx = 0;
        while (minHeap.size() > 0) {
            ans[idx++] = minHeap.remove().val;
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
