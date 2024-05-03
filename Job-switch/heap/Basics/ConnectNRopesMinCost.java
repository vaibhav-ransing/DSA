package Basics;
import java.util.PriorityQueue;

public class ConnectNRopesMinCost {


    public static long connectRopes(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int val : arr){
            minHeap.add(val);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int p1 = minHeap.remove();
            int p2 = minHeap.remove();
            cost += p1 + p2;
            minHeap.add(p1 + p2);
        }
        return cost;
    }

    public static void main(String[] args) {

    }
}
