package AALastGo.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {

    class MedianFinder {

        PriorityQueue<Integer> leftHeap; // Max-Heap (stores the smaller half of numbers)
        PriorityQueue<Integer> rightHeap; // Min-Heap (stores the larger half of numbers)

        public MedianFinder() {
            leftHeap = new PriorityQueue<>(Collections.reverseOrder());
            rightHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // Add to the max-heap first
            leftHeap.add(num);

            // Ensure the max of leftHeap is less than or equal to the min of rightHeap
            rightHeap.add(leftHeap.poll());

            // Balance the sizes if rightHeap becomes too large
            if (rightHeap.size() > leftHeap.size()) {
                leftHeap.add(rightHeap.poll());
            }
        }

        public double findMedian() {
            // If odd number of elements, return the top of the larger heap
            if (leftHeap.size() > rightHeap.size()) {
                return leftHeap.peek();
            }
            // If even number of elements, return the average of tops of both heaps
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }

}
