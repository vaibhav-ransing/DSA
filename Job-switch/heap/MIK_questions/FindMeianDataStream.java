import java.util.*;

public class FindMeianDataStream {
    class MedianFinder {

        PriorityQueue<Integer> rightMinHeap;
        PriorityQueue<Integer> leftMaxHeap;

        public MedianFinder() {
            rightMinHeap = new PriorityQueue<>();
            leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int val) {

            if (leftMaxHeap.size() == 0) {
                leftMaxHeap.add(val);
            } else {
                // val > lt
                int lt = leftMaxHeap.peek();
                // if val is greater than left peek element 
                    // then chances are that the val can be part of right split 
                    // if right peek is also smaller than val then when we balance the heap it will move to left based on size
                if (val > lt) {  
                    rightMinHeap.add(val);
                } else {
                    leftMaxHeap.add(val);
                }

                // balance the heaps
                if (rightMinHeap.size() > leftMaxHeap.size()) {
                    // example: 1, 2, 3   -> left = 1 and right = 2,3
                    // Now we want to keep left size greater than right size
                    // so we shift 2 from right to left heap 
                        // i.e. left = 1, 2  and right = 3
                    leftMaxHeap.add(rightMinHeap.remove());

                } else if (leftMaxHeap.size() > 1 + rightMinHeap.size()) {
                    // example 3, 2
                    // left = 3 , 2  right = _
                    // now difference in size is more than 1
                    // so we move the top of left to right
                    // i.e. lef = 2 and right =
                    rightMinHeap.add(leftMaxHeap.remove());
                }
            }
        }

        public double findMedian() {
            int n1 = leftMaxHeap.size();
            int n2 = rightMinHeap.size();
            if((n1 + n2)%2 == 0){
                return (leftMaxHeap.peek() + rightMinHeap.peek())/2.0;
            }else{
                return leftMaxHeap.peek();
            }
        }
    }
}
