import java.util.LinkedList;

public class SliingWindowMax {

    public int[] maxSlidingWindow(int[] arr, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[arr.length - k + 1];
        int i = 0, j = 0;
        for (j = 0; j < k - 1; j++) {
            int cv = arr[j];
            if (queue.size() == 0) {
                queue.addFirst(j);
            } else {
                while (queue.size() > 0 && cv > arr[queue.getLast()]) {
                    queue.removeLast();
                }
                queue.addLast(j);
            }
        }
        while (j < arr.length) {
            while (queue.size() > 0 && queue.getFirst() < i) {
                queue.removeFirst();
            }
            int cv = arr[j];
            while (queue.size() > 0 && cv > arr[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(j);
            ans[i] = arr[queue.getFirst()];
            j++;
            i++;
        }
        return ans;
    }
}
