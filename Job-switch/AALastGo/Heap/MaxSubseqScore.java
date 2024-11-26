package AALastGo.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubseqScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr = new int[nums1.length][];

        for (int i = 0; i < nums1.length; i++) {
            arr[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        long sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < k - 1; i++) {
            sum += arr[i][0];
            pq.add(arr[i]);
        }
        long ans = 0;
        for (int i = k - 1; i < nums1.length; i++) {
            if (pq.size() == k) {
                sum -= pq.peek()[0];
                pq.remove();
            }

            int curr[] = arr[i];ghjkghjkhgjkhjgkghjkkghjkhjkghjkghjkghjkgjk

            pq.add(curr);
            sum += curr[0];
            int minRn = curr[1];

            ans = Math.max(ans, sum * minRn);
        }
        return ans;
    }
}
