package Revision;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianDataStream {
    class MedianFinder {

        PriorityQueue<Integer> left; // max heap
        PriorityQueue<Integer> right; // min heap

        public MedianFinder() {
            // 3 2 5 1

            left = new PriorityQueue<>(Collections.reverseOrder()); // max values
            right = new PriorityQueue<>(); // min values
        }

        public void addNum(int val) {

            // from 3,2,5,1
            // when 5 comes that time `l = 2 and r = 3` -> so 5 > 3 there form 3 should be
            // shifted to left and then 5 should be added.
            if (right.size() > 0 && val > right.peek()) {
                left.add(right.remove());
                right.add(val);
            } else {
                left.add(val);
            }
            if (left.size() > right.size() + 1) {
                right.add(left.remove());
            }
        }

        public double findMedian() {
            if ((left.size() + right.size()) % 2 == 1) {
                return left.peek();
            } else {
                return (left.peek() + right.peek()) / 2.0;
            }
        }
    }
}
