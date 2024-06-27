import java.util.PriorityQueue;

public class MinNumOfKConsecutiveBitFlips {

    public static int minKBitFlips(int[] nums, int k) {

        int flipCount = 0, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        while (i < nums.length) {

            // reduce the flipCount which were done "k places before i"
            while (pq.size() > 0 && (i - pq.peek() >= k)) {
                pq.poll();
                flipCount--;
            }

            int curr_bit = nums[i];
            boolean fliped = false;

            // check if bit is flippe to 0 -> increase flipCount and add "i" to pq
            if ((curr_bit == 1 && flipCount % 2 == 1) || (curr_bit == 0 && flipCount % 2 == 0)) {
                flipCount++;
                ans++;
                pq.add(i);
                fliped = true;
            }
            if(fliped && (i + k) > nums.length)
                return -1;

            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 1, 0, 1, 1, 0 };
        int k = 3;
        minKBitFlips(nums, k);
    }
}