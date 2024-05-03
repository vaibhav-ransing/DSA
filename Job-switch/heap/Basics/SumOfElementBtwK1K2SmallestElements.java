package Basics;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElementBtwK1K2SmallestElements {

    public static long sumBetweenTwoKth(long arr[], long n, long k1, long k2) {
        // Your code goes here
        long k1sm = kthSmallestNumber(arr, k1);
        long k2sm = kthSmallestNumber(arr, k2);
        System.out.println(k1sm + " " + k2sm);
        long sum = 0;
        for (long val : arr) {
            if (val > k1sm && val < k2sm) {
                sum += val;
            }
        }
        return sum;
    }

    public static long kthSmallestNumber(long arr[], long k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (long val : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(val);
            } else {
                if (maxHeap.peek() > val) {
                    maxHeap.remove();
                    maxHeap.add(val);
                }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        long N = 7;
        long A[] = { 20, 8, 22, 4, 12, 10, 14 };
        // int A[] = { 4, 8, 10, 12, 14, 20, 22 };
        long K1 = 3, K2 = 6;
        sumBetweenTwoKth(A, N, K1, K2);
    }
}