package Basics;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (int key : map.keySet()) {
            minHeap.add(new Pair(key, map.get(key)));
        }
        int idx = 0;
        while (minHeap.size() > 0) {
            Pair top = minHeap.remove();
            for (int i = 0; i < top.freq; i++) {
                nums[idx + i] = top.val;
            }
            idx += top.freq;
        }
        return nums;
    }

    class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair o) { // min heap
            if (this.freq == o.freq) {
                // sort array in desending order if same frequency
                return this.val - o.val;
            } else {
                return this.freq - o.freq;
            }
        }

    }
}
