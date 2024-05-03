package Basics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < matrix.length; i++) {
            for (int val : matrix[i]) {
                if (pq.size() < k) {
                    pq.add(val);
                } else {
                    if (pq.peek() > val) {
                        pq.remove();
                        pq.add(val);
                    }
                }
            }
        }

        return pq.peek();
    }

    public int test(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int val : arr) {
                if (pq.size() < k) {
                    pq.add(val);
                } else {
                    if (pq.peek() > val) {
                        pq.remove();
                        pq.add(val);
                    }
                }
        }

        return pq.peek();
    }

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int val : arr){
            if(maxHeap.size() < k){
                maxHeap.add(val);
            }else{
                if(maxHeap.peek() > val){
                    maxHeap.remove();
                    maxHeap.add(val);
                }
            }

            if(minHeap.size() < k){
                minHeap.add(val);
            }else{
                if(minHeap.peek() < val){
                    minHeap.remove();
                    minHeap.add(val);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxHeap.peek());  // kth smallest
        ans.add(minHeap.peek());  // kth largest
        return ans;
	}

    public static void main(String[] args) {

    }
}
