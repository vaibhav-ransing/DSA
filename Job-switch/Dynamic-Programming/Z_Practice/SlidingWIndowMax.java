import java.util.ArrayDeque;
import java.util.Stack;

public class SlidingWIndowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> qeue = new ArrayDeque<>();
        // nums = [1,3,-1,-3,5,3,6,7], k = 3

        int i = 0, j = 0;

        while (j < nums.length) {
            while (j - i < k - 1) {
                int curr = nums[j];
                while (nums[qeue.peek()] < curr) {
                    qeue.remove();
                }
                qeue.add(j);
            }
        }

    }
}
