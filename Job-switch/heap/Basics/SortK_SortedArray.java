package Basics;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SortK_SortedArray {

    public static int[] nearlySorted(int[] array, int n, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int idx = 0;
        for(int i=0; i<array.length; i++){
            int val = array[i];
            if(minHeap.size()<=k){
                minHeap.add(val);
            }else{
                array[idx++] = minHeap.peek();  // or i-k will also work
                minHeap.remove();
                minHeap.add(val);
            }
        }
        while (minHeap.size() > 0) {
            array[idx++] = minHeap.remove();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        nearlySorted(arr, arr.length, 3);
    }
}

// 2 4 8 10 14
// 