package Basics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class K_ClosestNumbers {

    static class Pair implements Comparable<Pair> {

        int diff;
        int val;

        Pair(int val, int diff) {
            this.val = val;
            this.diff = diff;
        }

        public int compareTo(Pair o) {
            return o.diff - this.diff;
        }

        @Override
        public String toString() {
            return this.val + " " + this.diff;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for (int val : arr) {
            int diff = Math.abs(val - x);
            if (maxHeap.size() < k) {
                maxHeap.add(new Pair(val, diff));
            } else {
                if (maxHeap.peek().diff > diff) {
                    maxHeap.remove();
                    maxHeap.add(new Pair(val, diff));
                }
            }
            System.out.println(maxHeap.size());
        }
        List<Integer> ans = new ArrayList<>();
        while (maxHeap.size() > 0) {
            ans.add(maxHeap.remove().val);
        }
        Collections.sort(ans);
        return ans;

    }

        public List<Integer> findClosestElements2(int[] arr, int k, int x) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a,b) -> b-a );
            for (int val : arr) {
                if (k > 0) {
                    minHeap.add(val);
                    k--;
                    // 5, 6, 7, 8, 9
                    // k = 3, x = 7
                    // ans = 6,7,8
                } else if (Math.abs(minHeap.peek() - x) > Math.abs(val - x)) {  
                    // 5,6,7 is pushed, now 8 comes
                    // abs(5-7) = 2,   abs(8-7) = 1
                    // So 5 will be popped out and 8 will be pushed.
                    minHeap.remove();
                    minHeap.add(val);
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                result.add(minHeap.remove());
            }
            Collections.sort(result);
            return result;
        }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9 };
        int k = 3;
        int x = 7;
        findClosestElements(arr, k, x);
    }
}
