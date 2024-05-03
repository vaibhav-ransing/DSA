package Basics;
import java.util.*;
import java.io.*;

public class Solution {
    public static int[] sortByFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums)
            map.put(val, map.getOrDefault(val, 0) + 1);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int key : map.keySet()) {
            int currIdx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    currIdx = i;
                    break;
                }
            }
            minHeap.add(new Pair(key, map.get(key), currIdx));
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

    public static void main(String[] args) {
        int[] nums = { 5,2,8,1 };
        System.out.println(Arrays.toString(sortByFrequency(nums)));
    }
}

class Pair implements Comparable<Pair> {
    int val;
    int freq;
    int position;

    Pair(int val, int freq, int position) {
        this.val = val;
        this.freq = freq;
        this.position = position;
    }

    Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    public int compareTo(Pair o) { // min heap
        if (this.freq == o.freq) {
            // If two numbers have the same frequency, prioritize the one that appeared
            // earlier
            return this.position - o.position;
        } else {
            // Otherwise, prioritize the one with higher frequency (min heap)
            return o.freq - this.freq;
        }
    }
}
