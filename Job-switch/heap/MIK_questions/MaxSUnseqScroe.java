import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSUnseqScroe {

    class HeapSoln {

        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                arr[i] = new int[] { nums1[i], nums2[i] };
            }

            Arrays.sort(arr, (a, b) -> b[1] - a[1]);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0;

            // Initial sum and priority queue setup for the first k-1 elements
            for (int i = 0; i < k - 1; i++) {
                pq.add(arr[i][0]);
                sum += arr[i][0];
            }

            long ans = 0;

            // Loop to handle elements starting from k-1
            // Add the value in the queue and remove the top element if queue size is more than k also reduce the sum 
                // the (pq.size() > k) condition will only not execute for the first time i.e. when i=k-1
            for (int i = k - 1; i < n; i++) {
                int min = arr[i][1]; // Since array is sorted based on nums2 so min will be always smaller than previously occured vals.
                int val = arr[i][0];

                // Add the k-th element to the sum and priority queue
                sum += val;
                pq.add(val);

                // Remove the smallest element from the sum and priority queue if we have more
                // than k elements
                if (pq.size() > k) {
                    sum -= pq.poll();
                }

                // Calculate the current score
                ans = Math.max(ans, sum * (long) min);
            }

            return ans;
        }
    }

    class Recursive {

        int ans = 0;

        public long maxScore(int[] nums1, int[] nums2, int k) {
            helper(0, 0, Integer.MAX_VALUE, nums1, nums2, k);
            return ans;
        }

        public void helper(int idx, int sum, int min, int[] nums1, int[] nums2, int k) {
            if (k == 0) {
                ans = Math.max(ans, sum * min);
                return;
            }
            if (idx == nums1.length)
                return;
            helper(idx + 1, sum, min, nums1, nums2, k);
            helper(idx + 1, sum + nums1[idx], Math.min(min, nums2[idx]), nums1, nums2, k - 1);
        }
    }

    class Memoized {

        public int ans = 0;
        private Map<String, Long> memo = new HashMap<>();

        public long maxScore(int[] nums1, int[] nums2, int k) {
            helper(0, 0, Integer.MAX_VALUE, nums1, nums2, k);
            return ans;
        }

        public long helper(int idx, int sum, int min, int[] nums1, int[] nums2, int k) {
            if (k == 0) {
                ans = Math.max(ans, sum * min);
                return (long) sum * min;
            }
            if (idx == nums1.length)
                return 0;

            String key = idx + "," + sum + "," + min + "," + k;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            long exclude = helper(idx + 1, sum, min, nums1, nums2, k);
            long include = helper(idx + 1, sum + nums1[idx], Math.min(min, nums2[idx]), nums1, nums2, k - 1);

            long result = Math.max(exclude, include);
            memo.put(key, result);

            return result;
        }
    }
}
